package com.denkarz.service.Graph;

import com.denkarz.model.graph.Graph;
import com.denkarz.model.graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphServiceImpl implements GraphService {
    private final Integer MAX_WEIGHT = 10;

    @Override
    public List<Graph> generateGraph(int nodeCount) {
        Map<Character, Node> nodes = new HashMap<>();
        char name = 'A';
        for (int i = 0; i < nodeCount; i++) {
            Node node = new Node();
            node.setName(name++);
            node.setSearchProperty(false);
            nodes.put(node.getName(), node);
            System.out.println(node);
        }
        return generateGraphImpl(nodes);
    }

    private List<Graph> generateGraphImpl(Map<Character, Node> nodes) {
        List<Graph> graph = new ArrayList<>();
        graph.add(buildEdge(nodes.get('A'), nodes.get('B'), 6));
        graph.add(buildEdge(nodes.get('A'), nodes.get('C'), 2));
        graph.add(buildEdge(nodes.get('B'), nodes.get('D'), 8));
        graph.add(buildEdge(nodes.get('C'), nodes.get('D'), 7));
        graph.add(buildEdge(nodes.get('D'), null, Integer.MAX_VALUE));
        graph.add(buildEdge(nodes.get('C'), nodes.get('E'), 1));
        graph.add(buildEdge(nodes.get('E'), null, Integer.MAX_VALUE));
        graph.add(buildEdge(nodes.get('C'), nodes.get('F'), 3));
        graph.add(buildEdge(nodes.get('E'), nodes.get('F'), 1));
        graph.add(buildEdge(nodes.get('F'), nodes.get('G'), 1));
        graph.add(buildEdge(nodes.get('G'), null, Integer.MAX_VALUE));
        return graph;
    }

    private Graph buildEdge(Node source, Node target, Integer distance) {
        Graph edge = new Graph();
        edge.setSourceNode(source);
        edge.setTargetNode(target);
        edge.setDistance(distance);
        return edge;
    }

    @Override
    public void updatePropertyUsingDFS(List<Graph> graph, Character nodeName, Boolean newProperty) {
        Stack<Graph> stack = new Stack<>();
        stack.add(graph.get(0));
        stack.add(graph.get(1));
        dfsImpl(graph, stack, nodeName, newProperty);
    }

    private void dfsImpl(List<Graph> graph, Stack<Graph> stack, Character nodeName, Boolean newProperty) {
        List<Character> visitedNodeNames = new ArrayList<>();
        while (!stack.empty()) {
            Graph poll = stack.pop();
            addAll(graph, stack, visitedNodeNames, poll);
            if (visitedNodeNames.contains(poll.getSourceNode().getName())) {
                continue;
            }
            visitedNodeNames.add(poll.getSourceNode().getName());
            if (nodeName.equals(poll.getSourceNode().getName())) {
                poll.getSourceNode().setSearchProperty(newProperty);
            }
        }
    }

    @Override
    public void updatePropertyUsingBFS(List<Graph> graph, Character nodeName, Boolean newProperty) {
        Queue<Graph> queue = new ArrayDeque<>();
        queue.add(graph.get(0));
        queue.add(graph.get(1));
        bfsImpl(graph, queue, nodeName, newProperty);
    }

    private void bfsImpl(List<Graph> graph, Queue<Graph> queue, Character nodeName, Boolean newProperty) {
        List<Character> visitedNodeNames = new ArrayList<>();
        while (queue.size() > 0) {
            Graph poll = queue.poll();
            addAll(graph, queue, visitedNodeNames, poll);
            if (visitedNodeNames.contains(poll.getSourceNode().getName())) {
                continue;
            }
            visitedNodeNames.add(poll.getSourceNode().getName());
            if (nodeName.equals(poll.getSourceNode().getName())) {
                poll.getSourceNode().setSearchProperty(newProperty);
            }
        }
    }

    private void addAll(List<Graph> graph, Collection<Graph> collection, List<Character> visitedNodeNames, Graph poll) {
        for (Graph graph1 : graph) {
            final boolean endNode = poll.getTargetNode() == null;
            final boolean alreadyVisited = visitedNodeNames.contains(graph1.getSourceNode().getName());
            if (!endNode && !alreadyVisited && (graph1.getSourceNode().getName().equals(poll.getTargetNode().getName()))) {
                collection.add(graph1);
            }
        }
    }

    @Override
    public void updatePropertyUsingDjeikstra(List<Graph> graph, Character nodeName, Boolean newProperty) {
        List<Graph> nodes = new ArrayList<>();
        List<Character> visitedNodeNames = new ArrayList<>();
        nodes.add(graph.get(0));
        nodes.add(graph.get(1));
        updatePropertyUsingDjeikstraImpl(graph, nodes, visitedNodeNames, nodeName, newProperty);
        for (Character c : visitedNodeNames) {
            System.out.println(c);
        }

    }

    void updatePropertyUsingDjeikstraImpl(List<Graph> graph, List<Graph> nodes, List<Character> visitedNodeNames, Character nodeName, Boolean newProperty) {
        if (nodes.isEmpty()) {
            if (!visitedNodeNames.contains(nodeName)){
                System.out.println("No path found");
            }
            return;
        } else {
            Graph node = nodes.get(0);
            int maxDistance = Integer.MAX_VALUE;
            for (Graph n : nodes) {
                if (n.getDistance() < maxDistance) {
                    maxDistance = n.getDistance();
                    node = n;
                }
            }
            visitedNodeNames.add(node.getSourceNode().getName());
            if (nodeName.equals(node.getSourceNode().getName())) {
                node.getSourceNode().setSearchProperty(newProperty);
            }
            nodes = new ArrayList<>();
            addAll(graph, nodes, visitedNodeNames, node);
            updatePropertyUsingDjeikstraImpl(graph, nodes, visitedNodeNames, nodeName, newProperty);
        }
    }
}
