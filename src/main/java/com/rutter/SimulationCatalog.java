//package com.rutter;
//
//import com.Simulation.SimulationController;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import static com.rutter.ConfigurationPage.loadSimulationConfigurations;
//
//public class SimulationCatalog extends JFrame {
//    private static final long serialVersionUID = 1L;
//    private JPanel simulationPanel = new JPanel();
//    private ArrayList<JRadioButton> simulationConfigurationRadioboxes = new ArrayList<JRadioButton>();
//
//    private ArrayList<SimulationConfiguration> simulationConfigurations;
//    private JLabel simulationConfigLabel;
//    private JRadioButton[] simulationConfigJRadioButtons;
//
//    private JButton runSimulationButton;
//
//
//    public SimulationCatalog() {
//        setTitle("Simulation Configuration Catalog");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        add(simulationPanel);
//
//        Dimension windowSize = new Dimension(800, 600);
//        setPreferredSize(windowSize);
//
//        simulationPanel.setLayout(new GridLayout(0, 1));
//
//        simulationConfigLabel = new JLabel("Select Desired Configuration");
//        simulationPanel.add(simulationConfigLabel);
//
//
//        simulationConfigurations = loadSimulationConfigurations("SimulationConfiguration2.json");
//
//        int simulationConfigurationsSize = simulationConfigurations.size();
//
//        for (SimulationConfiguration configuration : simulationConfigurations) {
//            int simulationPeriod = configuration.getSimulationPeriod();
//            String simulationId = configuration.getSimulationId();
//            HashMap<RadarStation, Integer> radarQuantityMap = configuration.getRadarQuantityMap();
//            HashMap<ConsumerClient, Integer> consumerQuantityMap = configuration.getConsumerQuantityMap();
//            String name = configuration.getName();
//
//            SimulationConfiguration simulationConfig = new SimulationConfiguration(
//                    simulationPeriod,
//                    simulationId,
//                    radarQuantityMap,
//                    consumerQuantityMap);
//
//            System.out.println(simulationConfig.toString());
//        }
//
//
//        simulationConfigJRadioButtons = new JRadioButton[simulationConfigurationsSize];
//        ButtonGroup buttonGroup = new ButtonGroup();
//
//        for (int i = 0; i < simulationConfigurationsSize; i++) {
//            String checkBoxLabel = (simulationConfigurations.get(i).getName()).toString();
//            simulationConfigJRadioButtons[i] = new JRadioButton(checkBoxLabel);
//            buttonGroup.add(simulationConfigJRadioButtons[i]);
//            simulationConfigurationRadioboxes.add(simulationConfigJRadioButtons[i]);
//            simulationPanel.add(simulationConfigJRadioButtons[i]);
//        }
//
//        runSimulationButton = new JButton("Run Simulation");
//        // Add action listener to the button here
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(runSimulationButton);
//        simulationPanel.add(buttonPanel);
//
//        pack();
//        setLocationRelativeTo(null); // Center the window on the screen
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new SimulationCatalog();
//    }
//
//    //TODO ADD A NEW CONSTRUCTOR IN SIMULATIONCONTROLLER THAT ACCESPTS a string as parameter
//    public ActionListener runSimulation() {
//        return new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SimulationConfiguration simConfig = getSingleSimulationConfiguration(getSelectedimulationConfigName());
////                new SimulationController(simConfig); //TODO create constructor
//            }
//        };
//    }
//
//    public String getSelectedimulationConfigName(){
//        String electedimulationConfigName = "no matches found";
//        for (int i = 0; i < simulationConfigurationRadioboxes.size(); i++) {
//            if(simulationConfigurationRadioboxes.get(i).isSelected()){
//                electedimulationConfigName = simulationConfigurations.get(i).getName());
//            }
//            else{
//                electedimulationConfigName = "no matches found";
//            }
//        };
//        return electedimulationConfigName;
//    }
//
//    public SimulationConfiguration getSingleSimulationConfiguration(String selectedConfigurationName) {
//        String filePath = "SimulationConfiguration2.json";
//        List<SimulationConfiguration> simulationConfigurations = null;
//        SimulationConfiguration selectedConfiguration = null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            simulationConfigurations = objectMapper.readValue(new File(filePath), new TypeReference<List<SimulationConfiguration>>() {
//            });
//
//            for (SimulationConfiguration configuration : simulationConfigurations) {
//                int simulationPeriod = configuration.getSimulationPeriod();
//                String simulationId = configuration.getSimulationId();
//                HashMap<RadarStation, Integer> radarQuantityMap = configuration.getRadarQuantityMap();
//                HashMap<ConsumerClient, Integer> consumerQuantityMap = configuration.getConsumerQuantityMap();
//                String name = configuration.getName();
//
//
//                SimulationConfiguration simulationConfig = new SimulationConfiguration(
//                        simulationPeriod,
//                        simulationId,
//                        radarQuantityMap,
//                        consumerQuantityMap);
//
//                if (selectedConfigurationName == name) {
//                    selectedConfiguration = simulationConfig;
//                }
//                System.out.println(simulationConfig.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return selectedConfiguration;
//
//    }
//
//}
package com.rutter;

import com.Simulation.SimulationController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.rutter.ConfigurationPage.loadSimulationConfigurations;

public class SimulationCatalog extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel simulationPanel = new JPanel();
    private ArrayList<JRadioButton> simulationConfigurationRadioboxes = new ArrayList<JRadioButton>();

    private ArrayList<SimulationConfiguration> simulationConfigurations;
    private JLabel simulationConfigLabel;
    private JRadioButton[] simulationConfigJRadioButtons;

    private JButton runSimulationButton;


    public SimulationCatalog() {
        setTitle("Simulation Configuration Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(simulationPanel);

        Dimension windowSize = new Dimension(800, 600);
        setPreferredSize(windowSize);

        simulationPanel.setLayout(new GridLayout(0, 1));

        simulationConfigLabel = new JLabel("Select Desired Configuration");
        simulationPanel.add(simulationConfigLabel);

        simulationConfigurations = loadSimulationConfigurations("SimulationConfiguration2.json");

        int simulationConfigurationsSize = simulationConfigurations.size();

        for (SimulationConfiguration configuration : simulationConfigurations) {
            int simulationPeriod = configuration.getSimulationPeriod();
            String simulationId = configuration.getSimulationId();
            HashMap<RadarStation, Integer> radarQuantityMap = configuration.getRadarQuantityMap();
            HashMap<ConsumerClient, Integer> consumerQuantityMap = configuration.getConsumerQuantityMap();
            String name = configuration.getName();

            SimulationConfiguration simulationConfig = new SimulationConfiguration(
                    simulationPeriod,
                    simulationId,
                    radarQuantityMap,
                    consumerQuantityMap);

            System.out.println(simulationConfig.toString());
        }

        simulationConfigJRadioButtons = new JRadioButton[simulationConfigurationsSize];
        ButtonGroup buttonGroup = new ButtonGroup();

        for (int i = 0; i < simulationConfigurationsSize; i++) {
            String checkBoxLabel = simulationConfigurations.get(i).getName().toString();
            simulationConfigJRadioButtons[i] = new JRadioButton(checkBoxLabel);
            buttonGroup.add(simulationConfigJRadioButtons[i]);
            simulationConfigurationRadioboxes.add(simulationConfigJRadioButtons[i]);
            simulationPanel.add(simulationConfigJRadioButtons[i]);
        }

        runSimulationButton = new JButton("Run Simulation");
        runSimulationButton.addActionListener(runSimulation());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runSimulationButton);
        simulationPanel.add(buttonPanel);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimulationCatalog();
    }

    //TODO ADD A NEW CONSTRUCTOR IN SIMULATIONCONTROLLER THAT ACCESPTS a string as parameter
    public ActionListener runSimulation() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationConfiguration simConfig = getSingleSimulationConfiguration(getSelectedSimulationConfigName());
//                new SimulationController(simConfig);//TODO
            }
        };
    }

    public String getSelectedSimulationConfigName() {
        for (int i = 0; i < simulationConfigurationRadioboxes.size(); i++) {
            if (simulationConfigurationRadioboxes.get(i).isSelected()) {
                return simulationConfigurations.get(i).getName();
            }
        }
        return "no matches found";
    }

    public SimulationConfiguration getSingleSimulationConfiguration(String selectedConfigurationName) {
        String filePath = "SimulationConfiguration2.json";
        List<SimulationConfiguration> simulationConfigurations = null;
        SimulationConfiguration selectedConfiguration = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            simulationConfigurations = objectMapper.readValue(new File(filePath), new TypeReference<List<SimulationConfiguration>>() {
            });

            for (SimulationConfiguration configuration : simulationConfigurations) {
                int simulationPeriod = configuration.getSimulationPeriod();
                String simulationId = configuration.getSimulationId();
                HashMap<RadarStation, Integer> radarQuantityMap = configuration.getRadarQuantityMap();
                HashMap<ConsumerClient, Integer> consumerQuantityMap = configuration.getConsumerQuantityMap();
                String name = configuration.getName();

                SimulationConfiguration simulationConfig = new SimulationConfiguration(
                        simulationPeriod,
                        simulationId,
                        radarQuantityMap,
                        consumerQuantityMap);

                if (selectedConfigurationName.equals(name)) {
                    selectedConfiguration = simulationConfig;
                }
                System.out.println(simulationConfig.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectedConfiguration;
    }
}
