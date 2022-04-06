package com.denkarz;

import com.denkarz.model.graph.Graph;
import com.denkarz.model.graph.Node;
import com.denkarz.service.Graph.GraphService;
import com.denkarz.service.Graph.GraphServiceImpl;

import java.util.List;

public class Main {

    public static GraphService graphService;

    public static void main(String[] args) {
        int nodeCount = 7;
        graphService = new GraphServiceImpl();

        List<Graph> graph = graphService.generateGraph(nodeCount);
        graphService.updatePropertyUsingDFS(graph, 'G',true);
        System.out.println(graph);
        graphService.updatePropertyUsingBFS(graph,  'G',null);
        System.out.println(graph);
        graphService.updatePropertyUsingDjeikstra(graph,  'G',false);

    }
}
