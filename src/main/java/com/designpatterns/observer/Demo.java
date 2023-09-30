package com.designpatterns.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber aman = new Subscriber("Aman");
        channel.subscribe(aman);
        Subscriber raman = new Subscriber("Raman");
        channel.subscribe(raman);
       // channel.unsuscribe(raman);
        channel.newVideoUploaded("How to learn Java Design Patterns");
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press 1 to upload Video");
            System.out.println("Press 2 to create new subscriber");
            System.out.println("Press 3 to exit");

            int c = Integer.parseInt(br.readLine());
            if(c==1){
                System.out.println("Enter video title ");
                String videoTitle = br.readLine();
                channel.newVideoUploaded(videoTitle);
            }else if(c==2){
                System.out.println("Enter name of subscriber ");
                String subscriberName = br.readLine();
                Subscriber sc = new Subscriber(subscriberName);
                channel.subscribe(sc);
            }else if(c==3){
                System.out.println("thank you!");
                break;
            }else{
                System.out.println("Sorry, Wrong Input!");
                break;
            }
        }
    }
}
