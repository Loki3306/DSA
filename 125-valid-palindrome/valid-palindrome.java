class Solution {
public boolean isPalindrome(String s) {

int first = 0;
int last = s.length() - 1;

while(first < last){

while(first < last && !Character.isLetterOrDigit(s.charAt(first))){
first++;
}

while(first < last && !Character.isLetterOrDigit(s.charAt(last))){
last--;
}

char left = Character.toLowerCase(s.charAt(first));
char right = Character.toLowerCase(s.charAt(last));

if(left != right){
return false;
}

first++;
last--;
}

return true;
}
}