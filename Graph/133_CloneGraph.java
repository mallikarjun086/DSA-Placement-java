/*
Problem: LeetCode 133 - Clone Graph
Pattern: Graph (DFS)
Difficulty: Medium

Approach:
- Use DFS to traverse graph
- Use HashMap to store original → clone mapping
- Avoid revisiting nodes using map

Time Complexity: O(V + E)
Space Complexity: O(V)
*/
class Solution {
    HashMap<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        
        if(node==null)return null;
        if(map.containsKey(node)){
            return map.get(node);

        }
        Node clone=new Node(node.val);
        map.put(node,clone);

        for(Node nei:node.neighbors){
            clone.neighbors.add(cloneGraph(nei));

        }
        return clone;
    }
}
