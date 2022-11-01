package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchyBuilder<TItem extends IHaveHierarchicalStructure<TItem>> {

    private Map<Integer,TItem> items = new HashMap<>();
    TItem root;
    public void setElements(List<TItem> items) {
        for (TItem item :
                items) {
            this.items.put(item.getId(), item);
            if(item.getParentId()==null)root=item;
        }
    }

    public void buildHierarchy() {
        for (int id : items.keySet()) {
            TItem item = items.get(id);
            if(item.getParentId()==null) continue;
            TItem parent = items.get(item.getParentId());
            item.setParent(parent);
            parent.getChildren().add(item);
        }
    }



    public TItem getRootElement() {
        return root;
    }
}