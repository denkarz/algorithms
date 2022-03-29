package com.denkarz;

import com.denkarz.model.GraphNode;
import com.denkarz.service.Graph.GraphService;
import com.denkarz.service.Graph.GraphServiceImpl;

public class Main {

    public static GraphService graphService;

    public static void main(String[] args) {
        int depth = 5;
        int maxChildren = 3;
        graphService = new GraphServiceImpl();

        GraphNode graphNode = graphService.generateGraph(depth,maxChildren);
        graphService.updatePropertyUsingDFS(graphNode, "Node 2a", true);
        System.out.println(graphNode);
        graphService.updatePropertyUsingBFS(graphNode, "Node 1a", false);
        System.out.println(graphNode);
    }
}
