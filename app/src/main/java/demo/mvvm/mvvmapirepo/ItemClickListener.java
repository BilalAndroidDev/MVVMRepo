package demo.mvvm.mvvmapirepo;

import demo.mvvm.mvvmapirepo.POJOClasses.Item;

public interface ItemClickListener {
    void itemDeleteListener(Integer position);
    void itemEditClicked(Integer position);
}
