package com.binarytree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oscarmalagon
 * @since 9/3/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Node <T extends Object>{

    private Node leftChild;
    private Node rightChild;
    private T value;

}
