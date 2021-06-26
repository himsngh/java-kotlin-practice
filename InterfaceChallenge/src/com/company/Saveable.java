package com.company;

        import java.util.ArrayList;
        import java.util.List;

public interface Saveable {

    void read(List<String> savedValue);
    List<String> write();

}
