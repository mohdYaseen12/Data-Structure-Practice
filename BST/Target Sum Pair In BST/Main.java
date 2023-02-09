import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio {
	class Pair{
		Node node;
		int state;
		Pair(Node node, int state){
			this.node = node;
			this.state = state;
		}
	}
	Node getNextInNormal(Stack<Pair> st){
		while(st.size() > 0){
			Pair top = st.peek();
			if(top.state == 1){
				top.state++;
				if(top.node.left != null){
					st.push(new Pair(top.node.left,1));
				}
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.right != null){
					st.push(new Pair(top.node.right,1));
				}
				return top.node;
			}
			else{
				st.pop();
			}
		}
		return null;
	}

	Node getNextInRev(Stack<Pair> st){
			while(st.size() > 0){
			Pair top = st.peek();
			if(top.state == 1){
				top.state++;
				if(top.node.right != null){
					st.push(new Pair(top.node.right,1));
				}
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.left != null){
					st.push(new Pair(top.node.left,1));
				}
				return top.node;
			}
			else{
				st.pop();
			}
		}
		return null;
	}
    

    public void targetSum(Node root, int tar){
        // your code here
		Stack<Pair> normal = new Stack<>();
		Stack<Pair> reverse = new Stack<>();

		normal.push(new Pair(root,1));
		reverse.push(new Pair(root,1));

		Node left = getNextInNormal(normal);
		Node right = getNextInRev(reverse);
		boolean print = false;

		while(left.data < right.data){
			if(right.data + left.data == tar){
				System.out.println(left.data + " " + right.data);
				print = true;
				left = getNextInNormal(normal);
				right = getNextInRev(reverse);
			}
			else if(right.data + left.data > tar){
				right = getNextInRev(reverse);
			}
			else{
				left = getNextInNormal(normal);
			}
		}
		if(!print) System.out.print(-1);
		
    }

}