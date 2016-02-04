/*
 * Copyright © 2015 Salvadore Jefferson
 */

package com.jefferson.salvadore.datastruct;

import java.util.Comparator;
import javax.annotation.Nonnull;


/**
 * Binary Search Tree for building and manipulating graphs
 * 
 * @author Salvadore Jefferson
 * @version 3.0.0 10-18-2015
 * @param <T> The type of <code>Object</code> stored in the <code>BinarySearchTreeImpl</code>
 */
public class BinarySearchTreeImpl<T> implements BinarySearchTree<T> {


  Comparator BSTComparator;
  private BinarySearchTreeNode<T> rootNode = null;

  /**
   * A simple constructor to initialize a <code>Comparator</code> used for sorting and navigating
   * the <code>BinarySearchTree</code>
   * 
   * @param comparator A <code>Comparator</code> object
   */
  public BinarySearchTreeImpl(@Nonnull Comparator<? super T> comparator) {
    BSTComparator = comparator;
  }

  @Override
  public void add(@Nonnull final T object) {
    if (rootNode == null) {
      rootNode = new BinarySearchTreeNode<T>(object);
    } else {
      add(rootNode, object);
    }
  }

  /**
   * The public API method for searching the tree for a specific <code>Object</code>. Utilizes the
   * helper method {@link #contains(BinarySearchTreeNode, T)} for recursively searching the tree for
   * an <code>Object</code>
   * 
   * @param <T> The <code>Object</code> to find in the tree
   * @return a recursive call to {@link #contains(BinarySearchTreeNode, T) to find the
   *         <code>Object</code> or <code>false</code> if the tree is empty
   */
  @Override
  public boolean contains(@Nonnull T object) {
    if (rootNode != null) {
      return contains(rootNode, object);
    }
    return false;
  }

  /**
   * The public API method for printing the contents of the tree using depth-first in-order
   * traversal. Utilizes the helper method {@link #printAll(BinarySearchTreeNode)} for recursively
   * searching the tree for the next <code>Object</code> to print
   */
  @Override
  public void printAll() {
    if (rootNode != null) {
      printAll(rootNode);
    }
    return;

  }

  /**
   * A helper method with package-private access, used by {@link #printAll()} that recursively
   * searches the tree using depth-first in-order traversal.
   * 
   * @param node The active {@link BinarySearchTreeNode} being examined in the tree
   */
  protected static <T> void printAll(@Nonnull final BinarySearchTreeNode<T> node) {
    if (node != null) {

      printAll(node.getLeftChild());

      System.out.println(node.getValue().toString());

      printAll(node.getRightChild());
    }

  }

  /**
   * A helper method with package-private access, used by {@link #contains(T)} that recursively
   * searches the tree for the specified <code>Object</code> sent as an argument to the method
   * 
   * @param node
   * @param <T>
   * @return boolean Returns <code>true</code> if the argument entered is contained in the Tree,
   *         <code>false</code> otherwise
   */
  protected boolean contains(@Nonnull final BinarySearchTreeNode<T> node, @Nonnull final T object) {
    final T nodeValue = node.getValue();
    final int result = BSTComparator.compare(nodeValue, object);

    if (result == 0) {
      return true;
    } else if (result < 0) {
      if (node.getLeftChild() != null) {
        return contains(node.getLeftChild(), object);
      }
    } else if (result > 0) {
      if (node.getRightChild() != null) {
        return contains(node.getRightChild(), object);
      }
    }
    return false;

  }

  /**
   * A helper method with package-private access, used by the {@link #add(T)} method. Recursively
   * traverses the tree to find the correct child node to add new {@link BinarySearchTreeNode}
   * 
   * @param node The new {@link BinarySearchTreeNode} to add to the tree
   * @param <T> The <code>Object</code> contained by the new {@link BinarySearchTreeNode} being
   *        added to the tree
   */
  public void add(@Nonnull final BinarySearchTreeNode<T> node, @Nonnull final T object) {
    final T nodeValue = node.getValue();
    final int result = BSTComparator.compare(nodeValue, object);

    if (result == 0) {
      return; // nothing else to do
    }
    if (result < 0) {
      if (node.getRightChild() == null) {
        node.setRightChild(new BinarySearchTreeNode<T>(object));
      } else {
        add(node.getRightChild(), object);
      }
      return;
    }
    if (result > 0) {
      if (node.getLeftChild() == null) {
        node.setLeftChild(new BinarySearchTreeNode<T>(object));
      } else {
        add(node.getLeftChild(), object);
      }
      return;
    }
  }

  /**
   * Used to find the root of the tree
   * 
   * @return <code>rootNode</code> The first node in the tree
   */
  public BinarySearchTreeNode<T> getFirstNode() {
    return rootNode;
  }
}
