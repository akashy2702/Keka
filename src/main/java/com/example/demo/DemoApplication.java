package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Design and implement a small HTTP service to manage background jobs.
//
//The service should allow clients to submit jobs that need to be processed asynchronously. Jobs can have different priorities, and the system should decide how to handle them based on their priority.
//
//HIGH: Process the job immediately using a mock worker.
//
//MEDIUM: Record the job for later processing.
//
//LOW: Record the job without triggering immediate processing.
//
//The system should maintain the state of submitted jobs so that their progress and outcomes can be tracked.

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
