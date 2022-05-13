package com.example.laba3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class MainPageController {

    @FXML
    private Button importButton;

    @FXML
    private TreeView<String> reactorsTree;

    @FXML
    private void importFile() {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            Parser parser = new Parser(file);
            buildTree(parser.getReactorArrayList());
        } catch (Exception e) {
            error();
        }
    }

    public void buildTree(ArrayList<Reactor> reactorArrayList) {
        TreeItem<String> root = new TreeItem<>("Error");
        if (reactorArrayList.size() != 0) {
            root = new TreeItem<>("Reactors");
            for (Reactor reactor : reactorArrayList) {
                TreeItem<String> branch = new TreeItem<>(reactor.getName());
                TreeItem<String> leaf1 = new TreeItem<>("name : " + reactor.getName());
                TreeItem<String> leaf2 = new TreeItem<>("burnup : " + reactor.getBurnup());
                TreeItem<String> leaf3 = new TreeItem<>("kpd : " + reactor.getKpd());
                TreeItem<String> leaf4 = new TreeItem<>("enrichment : " + reactor.getEnrichment());
                TreeItem<String> leaf5 = new TreeItem<>("termal_capacity : " + reactor.getTermal_capacity());
                TreeItem<String> leaf6 = new TreeItem<>("electrical_capacity : " + reactor.getElectrical_capacity());
                TreeItem<String> leaf7 = new TreeItem<>("life_time : " + reactor.getLife_time());
                TreeItem<String> leaf8 = new TreeItem<>("first_load : " + reactor.getFirst_load());
                TreeItem<String> leaf9 = new TreeItem<>("source : " + reactor.getSource());
                branch.getChildren().addAll(leaf1, leaf2, leaf3, leaf4,
                        leaf5, leaf6, leaf7, leaf8, leaf9);
                root.getChildren().add(branch);
            }
        }
        reactorsTree.setRoot(root);
    }

    public static void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Error");
        alert.showAndWait();
    }

}