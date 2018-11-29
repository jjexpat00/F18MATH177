# F18MATH177

![alt-text][logo]

[logo]: https://github.com/jjexpat00/F18CS123A/raw/master/resources/wordmark1line.png "SJSU Logo"

##### Repo for Math 177 Final Project - <a href="https://johnstonmd.wordpress.com/" target="_blank">Professor Matthew Johnston</a>

###### By Jacob Chow

- [Preface](#Preface)
- [Introduction](#Introduction)
    * [Maximization & Constraints](#maximization--constraints)
    * [Solutions in a Feasible Region](#solutions-in-a-feasible-region)
    * [Binary Choices](#binary-choices)
- [Methodology](#methodology)
    * [Greedy Approach](#greedy-approach)
    * [Brute Force Method](#brute-force-method)
    * [Backtracking](#backtracking)
    * [Branch and Bound](#branch-and-bound)
- [Analysis](#analysis)
- [Final Thoughts](#final-thoughts)

## Preface

This project's original intent was to utilize <a href="https://www2.bc.edu/gerard-keough/software.html" target="_blank">LP Assistant</a> and implement a new GUI method to apply user-selected choices in the Branch and Bound (BnB) algorithm for integer optimization. The University of Bilkent has a great resource to learn more, found <a href="https://www.ie.bilkent.edu.tr/~mustafap/courses/bb.pdf" target="_blank">here</a>.

Unfortunately, due to time constraints and difficulty in understanding the source of LP Assistant, I find it impossible to develop my original idea. We all face great challenges in life and it is critical to only take on those that are realistic given certain constraints. Instead I will transition into programmatically working through a famous case that applies a variation of the BnB algorithm: the Knapsack Problem!

## Introduction

Let's dive into the knapsack problem:

```
You have a backpack with some maximum volume or weight and a unique assortment 
of items that have varying volumes and levels of associated value. You want to 
maximize the total value of what you can carry, given that everything has to 
fit inside the capacity constraint. What do you take?
```

Several variations of the problem exist, where items may not be unique and there are duplicates. Others include items that require other items, like how a portable stove requires a butane gas canister. For this project, I will focus on the simplest reduction of the knapsack problem.

We can express this problem succinctly with the following:

<br>
<p align="center">
<img src="https://latex.codecogs.com/gif.latex?\textup{Given&space;}n\textup{&space;number&space;of&space;items,&space;each&space;with&space;weight&space;}{w_i}\textup{&space;and&space;}{v_i}\textup{,&space;and&space;a&space;maximum&space;weight&space;}{W}{:}" title="definitions" />
</p>

<p align="center" >
<img src="https://latex.codecogs.com/gif.latex?\textup{maximize}\sum_{i=1}^{n}{v_ix_i}" title="objective function" />
</p>

<p align="center" >
<img src="https://latex.codecogs.com/gif.latex?\textup{subject&space;to&space;}\sum_{i=1}^{n}{w_ix_i}\leq&space;W\textup{&space;and&space;}{x_i}\in&space;\{0,1\}" title="constraints" />
</p>
<br>

Right off the bat, several linear programming concepts jump out:

1. Maximization!
2. Multiple solutions!
3. Binary (integer) choices!

Let's break them down.

#### Maximization & Constraints

The most fundamental part of linear programming is finding a solution (or lack thereof) to a problem. In the case of optimization given there is a solution, we typically wish to maximize or minimize the solution to obtain the best value. For the knapsack problem, we want to _maximize_ the value of all items in the sack. What is the highest value of stuff we can put into the bag? We call this the objective value of a function.

Unfortunately as all good things in life are limited by some factor, we have constraints to consider. We are not able to jam everything into this bag and call it a day. And no we cannot bring another bag with us or increase how much weight we can carry via strength training - that defeats the purpose of this problem. We are bound by the capacity of the bag and in linear optimization, constraints play a key role in determining the possible viable solutions to a given problem.

#### Solutions in a Feasible Region

Another fundamental part of linear programming is the solution set. Would life be great if all problems had a single solution? In most cases it would make life simpler, yet horribly uninteresting! When solving these types of problems, multiple solutions arise, giving us hope but further adding to the confusion. We call this "area" or set of solutions the feasible region when they satisfy the constraints of the problem.

It would be easy to say that all solutions are solutions and leave it at that, but as mathematicians, we have to take the next step in understanding. This ties in handily with the previous explanation of optimization. For the knapsack problem we are trying to maximize, and within our solution set we are trying to find the largest (best) feasible solution.

#### Binary Choices

Now this topic is not as abstract in understanding as the previous concepts: you either take an item or leave it behind. Simple enough!

We consider these yes or no questions to be binary (0,1), a subset of integer (whole number) problems. These types problems are reductions of other optimization examples where instead of taking half an item, we are required to take or leave the whole. The caveat lies within deception, as these types of problems are generally more difficult to solve since we have to eliminate non-integer solutions.

## Methodology

In approaching this problem, we need to flesh out not just any solution, but an optimal one. For this section, we will review the several concepts of the thought process behind an optimal approach at generating a solution.

#### Greedy Approach

Naturally, we would start by putting items with the highest value in the sack irrespective of their weights. We then might consider a ratio of value to weight being a decent deciding factor. This process can often lead to a solution, but more importantly it does not always result in an optimal one. This sorting method is, however, useful in speeding up the process involved in choosing the ideal combination of items to take. We need to think outside the box, yet somehow remain within the box.

This kind of thought process is necessary when deciding on algorithmic approaches to any problem.

#### Brute Force Method

As the name suggests, a brute force approach pile-drives us face first into a solution set containing all possible assortments. For the knapsack problem, brute forcing traverses all the items and checks for the objective value in each variation of combination. While this method is feasible in obtaining an optimal solution, it requires significantly more time and resources (memory) when computing a solution. It works, but it just is not good enough.

You can consider this approach suboptimal in the pursuit of optimality.

#### Backtracking

What happens if the combination of items we have exceeds the weight? Should I continue in attempt at adding items into the bag? Clearly from the brute force method will we run into this situation. Backtracking suggests us to stop when we encounter an _infeasible_ solution, because any exploration beyond would be meaningless. 

Through this method, we trim some excess off the solution set, but can we take it a step further?

#### Branch and Bound

We have finally arrived! The branch and bound method consolidates all of the previous concepts in formulating the solution. 

But wait, how do we actually do this?

As the name suggest, we will be working in the branches (or rather leaf nodes) in a tree-like data structure. The main idea to get out of this tree data structure is that there are different ways to move around the nodes - this movement will let us explore the possible combinations.

Another data structure used is a item queue, being first in, first out. This queue helps us organize these "branches" into meaningful sets of items.

First, we take a look at the usual suspects, objects with the highest value to weight ratio and process them first. Recall the greedy method - we do not expect a perfect solution just yet, but we are working towards one. Next, we want to implement a way to traverse the feasible region. By utilizing the general construction of a brute force method, we can easily create combinations of items. After this, we apply backtracking to stop at branches that don't have a better objective value to reduce the time spent calculating infeasible values. Here comes the trick: bounding.

In linear optimization, we have constraints that bound the entire solution set for a problem. With the knapsack problem, we are able to create such bounds by deciding whether or not to take an item (recall binary choice). If we choose to leave something behind, is the best possible objective value for that decision better or worse than if we took it? If the potential best solution down the line is worse than what we already have, there is no point in continuing further. We can keep track of the current best objective value and flush out decisions that would ultimately lead us to having a worse value.

We can summarize these steps or nodes with the following:

1. If we reach a choice that would be infeasible, we stop!
2. If we reach a choice that has a worse objective value, we stop!
3. If we reach a point where we cannot make a choice, we stop!
4. Otherwise, branch!

## Analysis



## Final Thoughts

Should you take a linear optimization class? Definitely.

In Math 177, I learned quite _a lot_ about the many tools found in the realm of linear optimization as well as many of their practical applications. Despite the coursework being objectively difficult, I really enjoyed the class' nature of being problem driven rather than via theory. Being a CS major, I definitely had my fair share of math classes where the instructor would curveball one theory after the other, not giving much time to breath and recognize we were being thrown fastballs the entire time. I cannot imagine what a math major goes through - major props.

The applications before and beyond the BnB algorithm have significant relevance to everyday topics. I am surprised these concepts are not exposed earlier on in general math curricula. Want to know the most cost effective way to produce a car? How much can I afford to adjust my sale price to remain competitive with my competitor's pricing? You ever heard of "Game Theory"? Albeit massive oversimplifications of complex concepts, you get the point.

Once you are able to grasp the fundamental aspects, everything layers in perfectly like a lasagna. Each iteration of problems you receive require the whole slice of thought - you cannot simply omit concepts because you learned them two months ago. Like algebra in grade school, it takes a deep understanding of the basics to be able to solve increasingly complex problems. It definitely has a rewarding feeling once you accomplish that.

##### GNU GENERAL PUBLIC LICENSE v3.0