// import java.util.Arrays; // �迭 ����ϱ� ���� ������ ���. �ּ����� ó���� System.out.println(Arrays.toString(Array)) ���� ����

public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(311,313);	
    }
    
    // ����Ű, ����Ű ����� �޼ҵ�. p,q�� ���δٸ� �Ҽ�
    public static void make_key(int p, int q) {
    	
    	// 1. p,q�� ���δٸ� �Ҽ����� �Ǻ�
    	if(p == q) {
    		System.out.println("���� ���� �ԷµǾ����ϴ�");
    		return;
    	} else if(isprime(p) == false) {
    		if(isprime(q) == false) {
    			System.out.println("p,q�� �Ѵ� �Ҽ��� �ƴմϴ�");
        		return;
    		} else {
        		System.out.println("p�� �Ҽ��� �ƴմϴ�");
        		return;
    		}
    	} else if(isprime(q) == false) {
    		System.out.println("q�� �Ҽ��� �ƴմϴ�");
    		return;
    	}
    	// 2�� ����
    	// 3. N = p*q, pi = (p-1)*(q-1)
    	int N = p*q;
    	int pi = (p-1)*(q-1);
    	
    	// 4. pi���� �۰�, pi�� ���μ��� ���� e�� ã��. �̶� e���� �������� �̿��Ͽ� ������ �� ��
    	
    	// �������� r : 0 ~ pi - 1 ������ ����
    	int r = (int)(Math.random()*(pi - 1));
    	// System.out.println(r);
    	
    	// while���� ���� ����
    	int i = 2;
    	int k = pi - r;
    	
    	// ���μ��� ���� e�� ã�� ����
    	while(i < k) {
    		// pi�� k �Ѵ� ������ �����μ��� ������ ���, �׶� k���� ���μ��� e�� �� �� ����
    		if(pi % i == 0 && k % i == 0) {
    			k = k-1;
    			i = 2;
    		} else {
    			i = i + 1;
    		}
    	}	// �̶� k���� ���μ��� ���� e
    	
    	// 5. Extended euclidean algorithm�� �̿�, de �� 1 (mod pi)�� �����ϴ� d�� ã�´�.
    	   	
    	int[] Array = {pi, k, 0, 1};
    	int[] temparr = new int[4];
    	// System.out.println(Arrays.toString(Array));
    	
    	// Extended euclidean algorithm ����
    	while (Array[1] > 0){
    		// temparr�� ���� �ִ� array�� ����
    		temparr[0] = Array[0];
    		temparr[1] = Array[1];
    		temparr[2] = Array[2];
    		temparr[3] = Array[3];
            int t = Array[0]/Array[1];
            
            // array �迭 ����
            Array[0] = temparr[1];
            Array[1] = temparr[0] % temparr[1];
            Array[2] = temparr[3];
            Array[3] = temparr[2] - (temparr[3] * t);
    	} 
        while (Array[2] < 0){
        	Array[2] = Array[2] + pi ;
        } // ���� Array[2] ���� d���� �ȴ�.
        
    	// 6. (N,e)�� ���� Ű, (N,d)�� ���� Ű
    	System.out.println(
    			String.format("(%s,%s) : ���� Ű, (%s,%s) : ���� Ű", N,k,N,Array[2])
    			);
    }
    
    // �Է¹��� ���� �Ҽ����� �Ǻ��ϴ� �޼ҵ�. ���ϰ��� true : �Ҽ�, false : �Ҽ��� �ƴ�
	public static boolean isprime(int n) {
		if(n < 2) {
			return false; // 1. �Է¹��� ���� 2 �̸� : �Ҽ��� �ƴ�
		} else if(n == 2 || n == 3) {
			return true; // 1. �Է¹��� ���� 2,3 : �Ҽ�
		} else {
			int i = 2;
			while(i < n/2 + 1) { // 3. 3���� ū �����̸� �Ǻ�. n�� n/2 + 1���� ���� ��� ���� �������� ����
				if(n % i == 0) {
					return false;
				} else {
					i = i + 1;
				}
			}
			return true;
		}
    }
    
}