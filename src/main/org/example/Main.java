package main.org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static class City {

        Integer id;
        String name;
        String region;
        String district;
        Integer population;
        String foundation;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getDistrict() {
            return district;
        }

        public Integer getPopulation() {
            return population;
        }

        public String getFoundation() {
            return foundation;
        }



        public City(int id, String name, String region, String district, int population, String foundation) {
            this.id = id;
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            return ("City{name='" + this.getName() + "', region='" + this.getRegion() + "', district='" + this.getDistrict() + "', population=" + this.getPopulation() + ", foundation='"+ this.getFoundation() + "'}"  );

        }
    }

    public static void main(String[] args) throws Exception {

        ArrayList<City> ArrCity = new ArrayList<City>();

        try {
            Scanner txtIn = new Scanner(new File("src/resources/Задача ВС Java Сбер.csv"), "UTF-8");
            txtIn.useDelimiter(";|\n|\r\n");

            while (txtIn.hasNext()) {
                Integer Id = txtIn.nextInt();
                String Name = txtIn.next();
                String Region = txtIn.next();
                String District = txtIn.next();
                Integer Population = txtIn.nextInt();
                String Foundation = txtIn.next();

                ArrCity.add(new City(Id, Name, Region, District, Population, Foundation));


            }
        } catch (FileNotFoundException e) {

        }



     Object[][] arrCity = new Object[ArrCity.size()][5];

     int population =0;
     int index=0;
        Object[][] numberOfCitiesInRegion = new Object[ArrCity.size()][2];
        String tempRegion = ArrCity.get(0).region;
        int tempNumberOfCitiesInRegion = 0;


        for (int i = 0; i < ArrCity.size(); i++) {
          arrCity[i][0] = ArrCity.get(i).name;
          arrCity[i][1] = ArrCity.get(i).region;
            arrCity[i][2] = ArrCity.get(i).district;
            arrCity[i][3] = ArrCity.get(i).population;
            arrCity[i][4] = ArrCity.get(i).foundation;

//            if (population>ArrCity.get(i).population) {
//
//            }
//            else {
//                population=ArrCity.get(i).population;
//                index=i;
//            }


            if (tempRegion.equals(ArrCity.get(i).region)) {
                tempNumberOfCitiesInRegion++;

            }
            else {

                numberOfCitiesInRegion[index][0]=tempRegion;
                numberOfCitiesInRegion[index][1]=tempNumberOfCitiesInRegion;
                System.out.println(numberOfCitiesInRegion[index][0] + " - " + numberOfCitiesInRegion[index][1]);

                tempRegion=ArrCity.get(i).region;
                index++;
                tempNumberOfCitiesInRegion=1;

            }

        }


//        NumberFormat local = NumberFormat.getNumberInstance(Locale.FRANCE);
//        DecimalFormat useFRLocal = (DecimalFormat)local;
//
//        System.out.println("[" + index + "] = " + useFRLocal.format(population)); // OR JUST SEE THE SOLUTION BELOW
//
//
//



//        if (ArrCity.size() > 0) {
//            Collections.sort(ArrCity, new Comparator<City>() {
//                @Override
//                public int compare(City o2, City o1) {
//                    return o1.getPopulation().compareTo(o2.getPopulation());
//                }
//            });
//        }


//        if (ArrCity.size() > 0) {
//            Collections.sort(ArrCity, new Comparator<City>() {
//                @Override
//                public int compare(City o1, City o2) {
//                    return o1.getName().compareTo(o2.getName());
//                }
//            });
//        }
//         System.out.println(Arrays.toString(ArrCity.toArray()).replace("[", "").
//                replace("]", "").replace("}, ", "}\n"));


//
//        if (ArrCity.size() > 0) {
//            Collections.sort(ArrCity, new Comparator<City>() {
//                @Override
//                public int compare(City o1, City o2) {
//                    return o1.getDistrict().compareTo(o2.getDistrict());
//                }
//            });
//        }
//
//        System.out.println("\n\n\n\n\n\n\n");
//
     //   System.out.println(Arrays.toString(ArrCity.toArray()).replace("[", "").replace("]", "").replace("}, ", "}\n"));

    }
}