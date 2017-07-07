/**
 * How to Generate Combinations
 */
/**
 * As programmers, occasionally
 * we come across cases where we
 * have to generate all possible
 * combinations of a set.
 * Now, I know the natural
 * solution is recursive but
 * I sometimes used to struggle
 * with getting it right.
 *
 * *___(Need to [href=/GeneratingPermutations.java.php](generate
 * *permutations)*? That's the
 * [href=/GeneratingPermutations.java.php](next post))___*
 *
 * If you are in the same
 * situation, I'd like to share
 * how I finally discovered
 * my favorite method for
 * generating combinations in
 * this post.
 */
/**
 * combinations.png
 */
/**
 * There are two possible
 * solutions for generating
 * combinations –
 *  (1) recursive
 *  and
 *  (2) iterative.
 * My favorite method is the
 * iterative because it uses a
 * really neat trick, but I’ll
 * start with explaining the
 * elegant recursive solution.
 */

import java.util.ArrayList;
import java.util.List;

class GeneratingCombinations {

/**
 * *_The Recursive Method_*
 */
/**
 * In this method, we go through
 * each element and either
 *  (a) Add it to the
 *  combination or
 *  (b) Not add it to the
 *  combination
 * Then, whenever we reach the
 * last element we have
 * generated a new combination!
 */
/**
 * recursive-tree.png
 */
/**
 * Simple? Let's try it below.
 **/
private void recursive_combinations(List<Object> combination,
                                      int ndx, Object[] elems) {
    if(ndx == elems.length) {

        // (reached end of list after selecting/not selecting)
        System.out.println(combination);

    } else {

        // (include element at ndx)
        combination.add(elems[ndx]);
        recursive_combinations(combination, ndx+1, elems);

        // (don't include element at ndx)
        combination.remove(elems[ndx]);
        recursive_combinations(combination, ndx+1, elems);

    }
}
public void recursive_combinations_start(Object[] elems) {
    List<Object> combination = new ArrayList<>();
    recursive_combinations(combination, 0, elems);
}

/**
 * *__The Iterative Method__*
 */
/**
 * Now for my favorite method. I
 * love this because it uses a
 * little trick – think about
 * the elements “standing” one
 * next to the other. Under it
 * we imagine a little switch –
 * “on” if the element is in the
 * set, “off” if it isn’t:
 */
/**
 * elements-in-line.png
 */
/**
 * On…off…on…off… sounds
 * familiar? It “looks like” the
 * binary representation of a
 * number. And what I find so
 * delightful is that – yes – we
 * _can_ use the binary
 * representation of a number to
 * generate all possible
 * combinations! The numbers
 * from 0 to (2^n-1) contain, in
 * their bits, all the
 * combinations we need! This is
 * simple and fun to code:
 */
public void iterate_combinations(Object[] elems) {
    int n = elems.length;
    for(int num = 0;num < (1 << n);num++) {
        List<Object> combination = new ArrayList<>();
        for(int ndx = 0;ndx < n;ndx++) {
            // (is the bit "on" in this number?)
            if((num & (1 << ndx)) != 0) {
                // then it's included in the list
                combination.add(elems[ndx]);
            }
        }
        // (show the current combination)
        System.out.println(combination);
    }
}

/**
 * Which method is your
 * favorite? Do you know any
 * other methods? Let me know in
 * the comments below.
 **/

public static void main(String[] args) {
    String elems[] = { "1", "2", "3", "4", "5" };

    System.out.println("Recursive combinations");
    new GeneratingCombinations().recursive_combinations_start(elems);
    System.out.println("Iterate combinations");
    new GeneratingCombinations().iterate_combinations(elems);
}

}

