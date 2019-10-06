import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.HashSet;

public class ConsoleParams {
    private String filePath;
    private boolean ignoreFirstRow;
    private HashSet<Integer> columnsToEdit;

    public ConsoleParams(String filePath, boolean ignoreFirstRow, HashSet<Integer> columnsToEdit) {
        this.filePath = filePath;
        this.ignoreFirstRow = ignoreFirstRow;
        this.columnsToEdit = columnsToEdit;
    }

    public static ConsoleParams parseParams(String[] args) throws InvalidParameterException {
        if (args.length < 3){
            throw new InvalidParameterException("Specify at least 3 arguments");
        }

        String path = new File(args[0]).getAbsolutePath();

        HashSet<Integer> columnIndices = new HashSet<>();
        for (int i = 2; i < args.length; i++) {
            if (!StringUtils.isNumeric(args[i])){
                throw new InvalidParameterException("every arguments except first and second should be numeric");
            }
            columnIndices.add(Integer.parseInt(args[i])-1);
        }
        return new ConsoleParams(path,Boolean.valueOf(args[1]),columnIndices);
    }

    public boolean isIgnoreFirstRow() {
        return ignoreFirstRow;
    }

    public void setIgnoreFirstRow(boolean ignoreFirstRow) {
        this.ignoreFirstRow = ignoreFirstRow;
    }

    public HashSet<Integer> getColumnsToEdit() {
        return columnsToEdit;
    }

    public void setColumnsToEdit(HashSet<Integer> columnsToEdit) {
        this.columnsToEdit = columnsToEdit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filepath:").append(this.filePath).append("\n");
        sb.append("ignoreFirstRow:").append(this.ignoreFirstRow).append("\n");
        sb.append("columnsToEdit:").append(this.columnsToEdit.toString());
        return sb.toString();
    }
}
