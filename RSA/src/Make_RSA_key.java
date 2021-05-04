public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(2,3,2);
    }
    
    // 공개키, 개인키 만드는 메소드. p,q는 서로다른 소수, 0 < r < (p-1)*(q-1)
    public static void make_key(int p, int q, int r) {
    	
    	// 1. p,q가 서로다른 소수인지 판별
    	// 2. 0 < r < (p-1)*(q-1) 판별
    	// 3. N = p*q, φ(N)=(p-1)*(q-1)
    	// 4. φ(N)보다 작고, φ(N)와 서로소인 정수 e를 찾음. 이때 e값에 변수 r을 통해 변동을 주자
    	// 5. Extended euclidean algorithm을 이용, de ≡ 1 (mod φ(N))를 만족하는 d를 찾는다.
    	// 6. (N,e)는 공용 키, (N,d)는 개인 키
    	
    	System.out.println("(N,e) : 공용 키, (N,d) : 개인 키");
    }
}