package org.springframework.samples.petclinic.admin;

import io.rollout.flags.RoxFlag;


public class Flags {
    // Example flag
    public static RoxFlag enableTutorial = new RoxFlag();

    public static void register() {
        // Register flags or any additional setup here if necessary
    }
}
