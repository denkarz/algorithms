package com.denkarz.service.Graph;

import com.denkarz.model.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphServiceImpl implements GraphService {
    private final Integer MAX_WEIGHT = 10;

    @Override
    public GraphNode generateGraph(int depth, int maxChildren) {
        return generateGraphImpl(depth, maxChildren, 'a');
    }

    private GraphNode generateGraphImpl(int depth, int maxChildren, Character index) {
        int childrenCount = 1 + (int) (Math.random() * maxChildren);
        GraphNode node = new GraphNode();
        String name = "Node " + depth + index;
        node.setName(name);
        node.setChildren(new ArrayList<>());
        if (depth > 0) {
            node.setWeightToParent(1 + (int) (Math.random() * MAX_WEIGHT));
            for (int i = 0; i < childrenCount; i++) {
                if (i==0){
                    index='a';
                }
                node.getChildren().add(generateGraphImpl(depth - 1, maxChildren, index));
                index++;
            }
        }
        return node;
    }

    @Override
    public void updatePropertyUsingDFS(GraphNode graph, String nodeName, Boolean newProperty) {
        List<String> visitedNodeNames = new ArrayList<>();
        dfsImpl(graph, nodeName, visitedNodeNames, newProperty);
    }

    private void dfsImpl(GraphNode graph, String nodeName, List<String> visitedNodeNames, Boolean newProperty) {
        if (visitedNodeNames.contains(graph.getName())) {
            return;
        }
        visitedNodeNames.add(graph.getName());
        if (nodeName.equals(graph.getName())) {
            graph.setSearchProperty(newProperty);
        } else {
            for (GraphNode node : graph.getChildren()) {
                dfsImpl(node, nodeName, visitedNodeNames, newProperty);
            }
        }
    }

    @Override
    public void updatePropertyUsingBFS(GraphNode graph, String nodeName, Boolean newProperty) {
        List<String> visitedNodeNames = new ArrayList<>();
        Queue<GraphNode> graphQueue = new ArrayDeque<>();
        graphQueue.add(graph);
        bfsImpl(graphQueue, nodeName, visitedNodeNames, newProperty);
    }

    private void bfsImpl(Queue<GraphNode> graphQueue, String nodeName, List<String> visitedNodeNames, Boolean newProperty) {
        while (graphQueue.size() > 0) {
            GraphNode graph = graphQueue.poll();
            if (visitedNodeNames.contains(graph.getName())) {
                continue;
            }
            visitedNodeNames.add(graph.getName());
            if (nodeName.equals(graph.getName())) {
                graph.setSearchProperty(newProperty);
            }
            graphQueue.addAll(graph.getChildren());
        }
    }
}
