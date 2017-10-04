You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view means when you look the tree from the top the nodes you will see will be called the top view of the tree. See the example below.
You only have to complete the function.
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4


SOLUTION:

They expect,
 at any level left subtree never can overlap right subtree and vice versa. In the beginning I was confused - what is expected in following cases:
                  1
                 / \
                2   3
               / \
              4   5
                   \
                    6
                     \
                      7
            Expected: 4-2-1-3-7 ? In fact - 4-2-1-3.
                  1
                 / \
                2   3
               / \
              4   5
                 /
                6
               /
              7
             /
            8
            Expected: 8-4-2-1-3 ? In fact - 4-2-1-3, again.


  Uncomment the two print statements mentioned in the code to get real TOP VIEW of the tree.