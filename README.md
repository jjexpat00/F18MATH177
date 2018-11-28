# F18MATH177

![alt-text][logo]

[logo]: https://github.com/jjexpat00/F18CS123A/raw/master/resources/wordmark1line.png "SJSU Logo"

##### Repo for Math 177 Final Project - <a href="https://johnstonmd.wordpress.com/" target="_blank">Professor Matthew Johnston</a>

###### By Jacob Chow

## Preface

This project's original intent was to utilize <a href="https://www2.bc.edu/gerard-keough/software.html" target="_blank">LP Assistant</a> and implement a new GUI method to apply user-selected choices in the Branch and Bound (BnB) algorithm for integer optimization. The University of Bilkent has a great resource to learn more, found <a href="https://www.ie.bilkent.edu.tr/~mustafap/courses/bb.pdf" target="_blank">here</a>.

Unfortunately, due to time constraints and difficulty in understanding the source of LP Assistant, I find it impossible to develop my original idea. We all face great challenges in life and it is critical to only take on those that are realistic given certain constraints. Instead I will transition into programmatically working through a famous case applying the BnB algorithm: the Knapsack Problem!

## Introduction

Let's dive into the knapsack problem:

```
You have a backpack with some maximum volume and an assortment of 
items that have varying volumes and levels of associated value. You 
want to maximize the total value of what you can carry, given that 
everything has to fit inside the volume constraint. What do you take?
```

<img src="https://latex.codecogs.com/gif.latex?\textup{maximize}\sum_{i=1}^{n}{v_ix_i}" title="\textup{maximize }\sum_{i=1}^{n}{v_ix_i}" />

<br>

<img src="https://latex.codecogs.com/gif.latex?\textup{subject&space;to&space;}\sum_{i=1}^{n}{w_ix_i}\leq&space;W\textup{&space;and&space;}{x_i}\in&space;\{0,1\}" title="\textup{subject to }\sum_{i=1}^{n}{w_ix_i}\leq W\textup{ and }{x_i}\in \{0,1\}" />



Right off the bat, several linear programming concepts jump out:

1. Maximization!
2. Multiple solutions!
3. Binary (integer) choices!

Let's break them down.

#### Maximization & Constraints

The most fundamental part of linear programming is finding a solution (or lack thereof) to a problem. In the case of optimization given there is a solution, we typically wish to maximize or minimize the solution to obtain the best value. For the knapsack problem, we want to _maximize_ the value of all items in the sack. What is the highest value of stuff we can put into the bag? 

Unfortunately as all good things in life are limited by some factor, we have constraints to consider. We are not able to jam everything into this bag and call it a day. And no we cannot bring another bag with us - that defeats the purpose of this problem. We are bound by the size of the bag and in linear optimization, constraints play a key role in determining the possible viable solutions to a given problem.

#### Solutions in a Feasible Region

Another fundamental part of linear programming is the solution set. Wouldn't life be great if all problems had a single solution? In most cases it would make life simpler, yet horribly uninteresting! When solving these types of problems, multiple solutions arise, giving us hope but further adding to the confusion. We call this "area" or set of solutions the Feasible Region when they satisfy the constraints of the problem.

It would be easy to say that all solutions are solutions and leave it at that, but as mathematicians, we have to take the next step in understanding. This ties in handily with the previous explanation of optimization. For the knapsack problem we are trying to maximize, and with our solution set we are trying to find the largest (best) feasible solution.

#### Binary Choices

Now this topic is not as deceivingly difficult to understand: you either take an item or leave it behind. Simple?

We consider these yes or no questions binary (0,1), a subset of integer (whole number) problems.

## Methodology

#### Greedy Algorithm

Naturally, we'd start by putting items with the highest value in the sack irrespective of their sizes. This can often lead to a solution, but more importantly it does not always result in speeding up the process involved in picking the ideal combination.

#### Brute Force Method

As the name suggests, a brute force approach pile-drives the problem face first into a solution set containing all possible combinations. While this method is feasible in obtaining an optimal solution, it requires significantly more time and resources (memory) when computing a solution. It works, but just is not good enough.

You can consider this approach suboptimal in the pursuit of optimality.

#### Branch and Bound



## Analysis



## Final Thoughts

Should you take a linear optimization class? Definitely.

In Math 177, I learned quite _a lot_ about the many tools found in the realm of linear optimization as well as many of their practical applications. Despite the coursework being objectively difficult, I really enjoyed the class' nature of being problem driven rather than via theory. Being a CS major, I definitely had my fair share of math classes where the instructor would curveball one theory after the other, not giving much time to breath and recognize we were being thrown fastballs the entire time. I can't imagine what a math major goes through - major props.

The applications before and beyond the BnB algorithm have significant relevance to everyday topics. I am surprised these concepts are not exposed earlier on in general math curricula. Want to know the most cost effective way to produce a car? How much can I afford to adjust my sale price to remain competitive with my competitor's pricing? You ever heard of "Game Theory"? Albeit massive oversimplifications of complex concepts, you get the point.

Once you are able to grasp the fundamental aspects, everything layers in perfectly like a lasagna. Each iteration of problems you receive require the whole slice of thought - you can't simply omit concepts because you learned them two months ago. Like algebra in grade school, it takes a deep understanding of the basics to be able to solve increasingly complex problems. It definitely has a rewarding feeling once you accomplish that.

##### GNU GENERAL PUBLIC LICENSE v3.0