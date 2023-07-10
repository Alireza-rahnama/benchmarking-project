package com.rutter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SimulationConfiguration {
    private int simulationPeriod;
    //this integer in these maps are the number of each radar and client instances
//    private ArrayList<HashMap<RadarStation, Integer>> radarsSimulationConfigurationCatalog;
//    private ArrayList<HashMap<ConsumerClient, Integer>> consumerClientSimulationConfigurationCatalog;

    private HashMap<RadarStation, Integer> radarQuantityMap;
    private HashMap<ConsumerClient, Integer> consumerQuantityMap;

    public SimulationConfiguration(int simulationPeriod,
                                   HashMap<RadarStation, Integer> radarQuantityMap,
                                   HashMap<ConsumerClient, Integer> consumerQuantityMap) {

        this.simulationPeriod = simulationPeriod;
        this.radarQuantityMap = radarQuantityMap;
        this.consumerQuantityMap = consumerQuantityMap;
    }

    public int getSimulationPeriod() {
        return simulationPeriod;
    }

    public void setRadarQuantityMap(HashMap<RadarStation, Integer> radarQuantityMap) {
        this.radarQuantityMap = radarQuantityMap;
    }

    public HashMap<ConsumerClient, Integer> getConsumerQuantityMap() {
        return consumerQuantityMap;
    }

    public void setConsumerQuantityMap(HashMap<ConsumerClient, Integer> consumerQuantityMap) {
        this.consumerQuantityMap = consumerQuantityMap;
    }

    public HashMap<RadarStation, Integer> getRadarQuantityMap() {
        return radarQuantityMap;
    }

    public void setSimulationPeriod(int simulationPeriod) {
        this.simulationPeriod = simulationPeriod;
    }

//    public ArrayList<HashMap<RadarStation, Integer>> getRadarsSimulationConfigurationCatalog() {
//        return radarsSimulationConfigurationCatalog;
//    }

//    public void setRadarsSimulationConfigurationCatalog(
//            ArrayList<HashMap<RadarStation, Integer>> radarsSimulationConfigurationCatalog) {
//        this.radarsSimulationConfigurationCatalog = radarsSimulationConfigurationCatalog;
//    }

//    public ArrayList<HashMap<ConsumerClient, Integer>> getConsumerClientSimulationConfigurationCatalog() {
//        return consumerClientSimulationConfigurationCatalog;
//    }

//    public void setConsumerClientSimulationConfigurationCatalog(
//            ArrayList<HashMap<ConsumerClient, Integer>> consumerClientSimulationConfigurationCatalog) {
//        this.consumerClientSimulationConfigurationCatalog = consumerClientSimulationConfigurationCatalog;
//    }

//    @Override
//    public String toString() {
//        return "SimulationConfiguration [simulationPeriod=" + simulationPeriod
//                + ", radarsSimulationConfigurationCatalog=" + radarsSimulationConfigurationCatalog
//                + ", consumerClientSimulationConfigurationCatalog=" + consumerClientSimulationConfigurationCatalog
//                + "]";
//    }

    public static void instantiateRadars(HashMap<RadarStation, Integer> radarQuantityMap) {

        List<String> radarsTypeList = radarQuantityMap.keySet().stream().map(s -> s.getType()).toList();
        List<Integer> radarsQuantityList = radarQuantityMap.values().stream().toList();

        int index = 0;
        for (int radarQuant : radarsQuantityList) {
            for (int i = 0; i < radarQuant; i++) {
                RadarStation newRadar = new RadarStation(radarsTypeList.get(index));
                System.out.println(newRadar.getType());
            }
            index++;
        }
    }

    public static void instantiateConsumerClients(HashMap<ConsumerClient, Integer> consumerQuantityMap) {

        List<String> consumerTypeList = consumerQuantityMap.keySet().stream().map(s -> s.getType()).toList();
        List<Integer> consumerQuantityList = consumerQuantityMap.values().stream().toList();

        int index2 = 0;
        for (int consumerQuant : consumerQuantityList) {
            for (int i = 0; i < consumerQuant; i++) {
                ConsumerClient newConsumerClient = new ConsumerClient(consumerTypeList.get(index2));
                System.out.println(newConsumerClient.getType());
            }
            index2++;
        }
    }

    public static void main(String[] args) {
        HashMap<RadarStation, Integer> radarQuantityMap = new HashMap<>();
        HashMap<ConsumerClient, Integer> consumerQuantityMap = new HashMap<>();

        RadarStation radar1 = new RadarStation("Sea Scan");
        int quantityRadar1 = 3;

        RadarStation radar2 = new RadarStation("Type B");
        int quantityRadar2 = 5;

        radarQuantityMap.put(radar1, quantityRadar1);
        radarQuantityMap.put(radar2, quantityRadar2);

        ConsumerClient client1 = new ConsumerClient("Sea view");
        int quantityClient1 = 1;

        ConsumerClient client2 = new ConsumerClient("S6 Web");
        int quantityClient2 = 2;

        consumerQuantityMap.put(client1, quantityClient1);
        consumerQuantityMap.put(client2, quantityClient2);


//        radarQuantityMap.keySet().stream().map(s -> s.getType()).forEach(System.out::println);
//        radarQuantityMap.entrySet().stream().forEach(System.out::println);

//        radarQuantityMap.entrySet().stream().
//                map(s -> s.getKey()).
//                map(r->new RadarStation(r.getType()).getType()).
//                forEach(System.out::println);

//        List<String> radarsList = radarQuantityMap.keySet().stream().map(s -> s.getType()).toList();
//        System.out.println(radarsList);
        instantiateRadars(radarQuantityMap);
        instantiateConsumerClients(consumerQuantityMap);

    }
}
