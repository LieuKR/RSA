// import java.util.Arrays; // 배열 출력하기 위해 가져온 모듈. 주석으로 처리한 System.out.println(Arrays.toString(Array)) 에서 사용됨

public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(311,313);	
    }
    
    // 공개키, 개인키 만드는 메소드. p,q는 서로다른 소수
    public static void make_key(int p, int q) {
    	
    	// 1. p,q가 서로다른 소수인지 판별
    	if(p == q) {
    		System.out.println("같은 수가 입력되었습니다");
    		return;
    	} else if(isprime(p) == false) {
    		if(isprime(q) == false) {
    			System.out.println("p,q가 둘다 소수가 아닙니다");
        		return;
    		} else {
        		System.out.println("p가 소수가 아닙니다");
        		return;
    		}
    	} else if(isprime(q) == false) {
    		System.out.println("q가 소수가 아닙니다");
    		return;
    	}
    	// 2번 삭제
    	// 3. N = p*q, pi = (p-1)*(q-1)
    	int N = p*q;
    	int pi = (p-1)*(q-1);
    	
    	// 4. pi보다 작고, pi와 서로소인 정수 e를 찾음. 이때 e값에 랜덤값을 이용하여 변동을 줄 것
    	
    	// 랜덤변수 r : 0 ~ pi - 1 사이의 난수
    	int r = (int)(Math.random()*(pi - 1));
    	// System.out.println(r);
    	
    	// while문을 위한 변수
    	int i = 2;
    	int k = pi - r;
    	
    	// 서로소인 정수 e를 찾는 과정
    	while(i < k) {
    		// pi와 k 둘다 나누는 공통인수가 존재할 경우, 그때 k값은 서로소인 e가 될 수 없음
    		if(pi % i == 0 && k % i == 0) {
    			k = k-1;
    			i = 2;
    		} else {
    			i = i + 1;
    		}
    	}	// 이때 k값이 서로소인 정수 e
    	
    	// 5. Extended euclidean algorithm을 이용, de ≡ 1 (mod pi)를 만족하는 d를 찾는다.
    	   	
    	int[] Array = {pi, k, 0, 1};
    	int[] temparr = new int[4];
    	// System.out.println(Arrays.toString(Array));
    	
    	// Extended euclidean algorithm 과정
    	while (Array[1] > 0){
    		// temparr에 원래 있던 array값 저장
    		temparr[0] = Array[0];
    		temparr[1] = Array[1];
    		temparr[2] = Array[2];
    		temparr[3] = Array[3];
            int t = Array[0]/Array[1];
            
            // array 배열 변경
            Array[0] = temparr[1];
            Array[1] = temparr[0] % temparr[1];
            Array[2] = temparr[3];
            Array[3] = temparr[2] - (temparr[3] * t);
    	} 
        while (Array[2] < 0){
        	Array[2] = Array[2] + pi ;
        } // 이제 Array[2] 값이 d값이 된다.
        
    	// 6. (N,e)는 공용 키, (N,d)는 개인 키
    	System.out.println(
    			String.format("(%s,%s) : 공용 키, (%s,%s) : 개인 키", N,k,N,Array[2])
    			);
    }
    
    // 입력받은 값이 소수인지 판별하는 메소드. 리턴값이 true : 소수, false : 소수가 아님
	public static boolean isprime(int n) {
		if(n < 2) {
			return false; // 1. 입력받은 값이 2 미만 : 소수가 아님
		} else if(n == 2 || n == 3) {
			return true; // 1. 입력받은 값이 2,3 : 소수
		} else {
			int i = 2;
			while(i < n/2 + 1) { // 3. 3보다 큰 정수이면 판별. n을 n/2 + 1보다 작은 모든 수와 나눠보는 과정
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