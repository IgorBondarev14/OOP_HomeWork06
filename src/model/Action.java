package model;

import java.util.List;

public interface Action {
    List<String> readAllStrings();
    void saveAllStrings(List<String> strings);
}
