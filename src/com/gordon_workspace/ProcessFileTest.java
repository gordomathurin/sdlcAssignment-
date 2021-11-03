package com.gordon_workspace;

import java.io.File;
import java.io.FileNotFoundException;


import static org.junit.jupiter.api.Assertions.*;

class ProcessFileTest  implements ProjectVariables {

    @org.junit.jupiter.api.Test
    void verifyRightFilePath() {
        File fileName = new File(poemFilePath);
        assertTrue(fileName.exists());
    }

}