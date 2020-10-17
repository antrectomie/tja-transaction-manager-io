package com.tja.transaction.manager.io.readers;

import com.tja.transaction.manager.config.AppConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileUtils {

    static void moveFile(Path filePath, boolean isInError) {
        String moveDir = isInError ? AppConfig.getConfigInstance().getTransactionErrorDir() :
                AppConfig.getConfigInstance().getTransactionProcessedDir();
        Path movePathDir = Paths.get(moveDir);
        Path pathToMove = movePathDir.resolve(filePath.getFileName());
        if (!Files.exists(movePathDir)) {
            try {
                Files.createDirectory(movePathDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.move(filePath, pathToMove);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
