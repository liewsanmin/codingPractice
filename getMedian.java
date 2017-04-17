public class GetMedian{
    
    public GetMedian(){

    }

    /* This function returns median of ar1[] and ar2[].
       Assumptions in this function:
       Both ar1[] and ar2[] are sorted arrays
       Both have n elements
       */
    public double getMedian(int ar1[], int ar2[], int n){
        int i = 0;
        int j = 0;
        int m1 = -1, m2 = -1;
        /* Since there are 2n elements, median will be average
         of elements at index n-1 and n in the array obtained after
         merging ar1 and ar2 */
         for(int count = 0; count <= n; count++){
             /*Below is to handle case where all elements of ar1[] are
             smaller than smallest(or first) element of ar2[]*/
             if(i == n){
                 m1 = m2;
                 m2 = ar2[0];
                 break;
             }

             /*Below is to handle case where all elements of ar2[] are
             smaller than smallest(or first) element of ar1[]*/
             else if(j == n){
                 m1 = m2;
                 m2 = ar1[0];
                 break;
             }

             if(ar1[i] < ar2[j]){
                 m1 = m2;
                 m2 = ar1[i];
                 i++;
             }
             else{
                 m1 = m2;
                 m2 = ar2[j];
                 j++;
             }
         }
         double ans = (m1 + m2) / 2.0;
         return ans;
    }

}
