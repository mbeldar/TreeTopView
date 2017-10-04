
import java.util.*;

public class Main {
    static HashMap<WidthHeight,Node > hashMapForTree = new HashMap<>();
    static List<NodeInfo> nodeInfoList = new ArrayList<>();
    public static void main(String[] args) {
	// write your code here
        Node x14 = new Node(14,null,null);
        Node x13 = new Node(13,null,x14);
        Node x12 = new Node(12,null,x13);
        Node x11 = new Node(11,x12,null);
        Node x10 = new Node(10,null,x11);
        Node x7 = new Node(7,null,null);
        Node x6 = new Node(6,x7,null);
        Node x5 = new Node(5,x6,null);
        Node x4 = new Node(4,x5,null);
        Node x3 = new Node(3,null,x10);
        Node x2 = new Node(2,null,null);
        Node x1 = new Node(1,x2,x4);
        Node x0 = new Node(0,x1,x3);

        width(x0,0,0);
       // System.out.println(hashMapForTree);
        Map<WidthHeight,Node >  treeMap = new TreeMap<WidthHeight,Node > (hashMapForTree);

        printMap(treeMap);


        printList();


    }

    private static void printList() {
        for(int i = 0; i< nodeInfoList.size(); i++){
            System.out.print(nodeInfoList.get(i).node.data+" ");
        }
    }

    public static void printMap(Map<WidthHeight, Node> map) {
        boolean f = true;
        int lastW = 0;
      //  System.out.println(map);
        for (Map.Entry entry : map.entrySet()) {
            WidthHeight x  =(WidthHeight) entry.getKey();

            NodeInfo nodeInfo = new NodeInfo((Node)entry.getValue(),x.h,x.w);

            if(f)
            {
                f = false;
                lastW = x.w;
                //uncomment this line
               // System.out.print(((Node)(entry.getValue())).data+" ");
                nodeInfoList.add(nodeInfo);
            }
            else
            {
                if(lastW!=x.w) {

                    //uncomment this line
                    //  System.out.print(((Node)(entry.getValue())).data + " ");

                    if (nodeInfoList.get(nodeInfoList.size()-1).h-nodeInfo.h>=2) {
                        nodeInfoList.clear();
                        nodeInfoList.add(nodeInfo);
                    }
                    else {
                    if (nodeInfoList.get(nodeInfoList.size()-1).h-nodeInfo.h<=-2)
                    {}else {
                        nodeInfoList.add(nodeInfo);
                    }
                }
                }
                lastW = x.w;
            }
        }
    }

    static  void width(Node root, int w, int h) {


        if(root.left != null)
            width(root.left,w-1,h+1);

        hashMapForTree.put(new WidthHeight(w,h),root);

        if(root.right != null)
            width(root.right, w+1,h+1);

    }

}

class Node {
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    int data;
    Node left;
    Node right;
}
class NodeInfo {
    public NodeInfo(Node node, int h, int w) {
        this.node = node;
        this.h = h;
        this.w = w;
    }

    Node node;
    int h;
    int w;
}
class WidthHeight implements Comparable<WidthHeight>{
    int w;
    int h;

    public WidthHeight(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "("+w+","+h+")";
    }

    @Override
    public int compareTo(WidthHeight o) {

        if(this.w==o.w)
        {
            if (this.h<o.h)
                return -1;
            return 1;
        }

        if(this.w<o.w)
        return -1;

        return 1;
    }
}

