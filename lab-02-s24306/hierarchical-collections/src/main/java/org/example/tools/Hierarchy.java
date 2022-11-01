package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

public class Hierarchy<TItem extends IHaveHierarchicalStructure<TItem>> {

    private TItem root;
    public void setRootElement(TItem item) {
        this.root=item;
    }

    private TItem findByIdRecursive(int id, TItem item){
        if(item.getId() == id)return item;
        for (TItem child : item.getChildren()) {
            TItem result = findByIdRecursive(id, child);
            if(result!=null)return result;
        }
        return null;
    }

    public TItem findElementById(int i) {
        return findByIdRecursive(i, root);
    }
}