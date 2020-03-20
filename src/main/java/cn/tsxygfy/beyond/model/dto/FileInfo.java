package cn.tsxygfy.beyond.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {

    private String fileName;

    private String fileUrl;

    private int fileSize;
}
