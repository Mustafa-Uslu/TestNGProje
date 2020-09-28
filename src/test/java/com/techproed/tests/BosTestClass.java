package com.techproed.tests;

public class BosTestClass {
    public static void main(String[] args) {

    StringBuilder stb = new StringBuilder();
    stb.append("semra");
    if (stb.equals(stb.reverse())) {
            System.out.println("True");
        }//true
        else
    System.out.println("false");    //false
}
    /*
        static int min (int a ,int b){
            return a<b?a:b;
        }
        public static void main(String args[]){
            boolean landingGearDeployed = false;
            int now=1000;
            int takeoffTime = 95;
            int estLandTime = 1125;
            int visibility = 990;
            int relativeAltitude = 2000;
            if(!landingGearDeployed &&
                    (min(now-takeoffTime,estLandTime-now))<
                            (visibility < 1000 ? 180 :120) ||
                    relativeAltitude <
                            (visibility < 1000 ? 2500 :2000)
            )
            {
                System.out.println("landing gear");
            }

        }
        */
    }
