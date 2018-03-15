package com.practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Vaccination
{
    
    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        int ncities = in.nextInt();
        int nclinics = in.nextInt();
        PriorityQueue<City> cityDataQueue = new PriorityQueue<>();
        City city;
        float n = 0;
        for (int i = 1; i <= ncities; i++)
        {
            n = (float)in.nextInt();
            city = new City(i,1,n,n);
            cityDataQueue.add(city);
        }
        
        findMaxNumberInClinic(ncities, nclinics, cityDataQueue);
        in.close();
    }

    private static void findMaxNumberInClinic(int ncities, int nclinics, PriorityQueue<City> citydataqueue)
    {
        for (int i = ncities; i < nclinics; i++)
        {
           City city = citydataqueue.poll();
           city.noOfClinics++;
           city.numberVaccinated = city.population/(float)city.noOfClinics;
           citydataqueue.add(city);
        }
        System.out.println("number of people vaccinated : "+ Math.round(citydataqueue.peek().numberVaccinated));
    }
    
}
class City implements Comparable<City>{
    public Integer cityNumber;
    public Integer noOfClinics;
    public Float population;
    public Float numberVaccinated;
    
    public City(Integer city, Integer clinics, Float population, float numbervaccinated)
    {
        cityNumber = city;
        noOfClinics = clinics;
        this.population=population;
        numberVaccinated = numbervaccinated;
    }


    @Override
    public int compareTo(City o)
    {
       if(o.numberVaccinated > this.numberVaccinated)
           return 1;
       else if(o.numberVaccinated < this.numberVaccinated)
           return -1;
       else return 0;
    }


    @Override
    public String toString()
    {
        return "City [cityNumber=" + cityNumber + ", noOfClinics=" + noOfClinics + ", population=" + population + ", numberVaccinated="
            + numberVaccinated + "]";
    }
}