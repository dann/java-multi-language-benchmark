// Copyright 2011 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * A simple class simulating the concept of Basic Blocks
 *
 * @author rhundt
 */

package cfg;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

/**
 * class BasicBlock
 * 
 * BasicBlock only maintains a vector of in-edges and a vector of out-edges.
 */
public class BasicBlock {

  static int numBasicBlocks = 0;

  public static int getNumBasicBlocks() {
    return numBasicBlocks;
  }

  public BasicBlock(int name) {
    this.name = name;
    inEdges = new ObjectArrayList<BasicBlock>(2);
    outEdges = new ObjectArrayList<BasicBlock>(2);
    ++numBasicBlocks;
  }

  public void dump() {
    System.out.format("BB#%03d: ", getName());
    if (inEdges.size() > 0) {
      System.out.format("in : ");
      BasicBlock[] inEdgeBlocks = inEdges.elements();
      final int inEdgeSize = inEdgeBlocks.length;
      for (int i = 0; i < inEdgeSize; i++) {
        System.out.format("BB#%03d ", inEdgeBlocks[i].getName());
      }
    }
    if (outEdges.size() > 0) {
      System.out.format("out: ");
      BasicBlock[] outEdgeBlocks = inEdges.elements();
      final int outEdgeSize = outEdgeBlocks.length;
      for (int i = 0; i < outEdgeSize; i++) {
        System.out.format("BB#%03d ", outEdgeBlocks[i].getName());
      }
    }
    System.out.println();
  }

  public int getName() {
    return name;
  }

  public ObjectArrayList<BasicBlock> getInEdges() {
    return inEdges;
  }

  public ObjectArrayList<BasicBlock> getOutEdges() {
    return outEdges;
  }

  public int getNumPred() {
    return inEdges.size();
  }

  public int getNumSucc() {
    return outEdges.size();
  }

  public void addOutEdge(BasicBlock to) {
    outEdges.add(to);
  }

  public void addInEdge(BasicBlock from) {
    inEdges.add(from);
  }

  private ObjectArrayList<BasicBlock> inEdges, outEdges;
  private int name;
};
