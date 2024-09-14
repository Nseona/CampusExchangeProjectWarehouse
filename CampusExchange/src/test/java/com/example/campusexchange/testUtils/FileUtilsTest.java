package com.example.campusexchange.testUtils;

import com.example.campusexchange.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class FileUtilsTest {
    @Autowired
    private FileUtils fileUtils;

    @Test
    public void testGetValue(){
        System.out.println(fileUtils.getFileRootPath());
    }
}
