
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import main.NamesOfTribes;
import model.Ork;

/**
 *
 * @author elenagoncarova
 */
public class ArmyTreeModel implements TreeModel {
    private String root = "Армия";
    
    private ArrayList<String> tribeList = new ArrayList<String>();
    private ArrayList<Ork>[] orkNodes;
    private final List<TreeModelListener> listeners = new ArrayList<TreeModelListener>();

    public ArmyTreeModel() {
        tribeList.addAll(Arrays.asList(NamesOfTribes.TRIBES));
        orkNodes = new ArrayList[tribeList.size()];
        for (int i = 0; i < tribeList.size(); i++) {
            orkNodes[i] = new ArrayList<Ork>();
        }
    }

    public ArrayList<String> getTribeList() {
        return tribeList;
    }

    private void printTree() {
        for (int i = 0; i < orkNodes.length; i++) {
            System.out.println("Племя: " + tribeList.get(i));
            for (int j = 0; j < orkNodes[i].size(); j++) {
                System.out.println(orkNodes[i].get(j));
            }
        }
    }

    public void addOrk(Ork ork, String tribe) {
        int idx = tribeList.indexOf(tribe);
        orkNodes[idx].add(ork);
        for (TreeModelListener listener : listeners) {
            listener.treeStructureChanged(
                    new TreeModelEvent(this, new Object[] { getRoot() })
            );
        }
        printTree();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    private final int getRootChild(Object node)
    {
        int idx = -1;
        for (int i = 0; i < tribeList.size(); i++){
            if (tribeList.get(i) == node) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    @Override
    public int getChildCount(Object node)
    {
        int idx = getRootChild(node);
        if ( node == root )
            return tribeList.size();
        else if ( idx >= 0 && node == tribeList.get(idx))
            return orkNodes[idx].size();
        return 0;
    }

    @Override
    public Object getChild(Object node, int index)
    {
        int idx = getRootChild(node);
        if ( node == root )
            return tribeList.get(index);
        else if ( idx >= 0 && node == tribeList.get(idx))
            return orkNodes[idx].get(index);
        return null;
    }

    @Override
    public int getIndexOfChild(Object node, Object child)
    {
        int idx = getRootChild(node);
        if ( node == root )
            return tribeList.indexOf(child);
        else if ( idx >= 0 && node == tribeList.get(idx))
            return orkNodes[idx].indexOf(child);
        return 0;
    }

    @Override
    public boolean isLeaf(Object node)
    {
        int idx = getRootChild(node);
        return node != root && idx == -1;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object value) {
        System.out.println(path);
        System.out.println(value);
    }

    @Override
    public void addTreeModelListener(TreeModelListener tml) {
        listeners.add(tml);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tml) {
        listeners.remove(tml);
    }
    
}
