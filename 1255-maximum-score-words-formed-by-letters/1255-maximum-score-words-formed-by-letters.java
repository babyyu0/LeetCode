class Solution {
	private static int N, answer;
	private static int[] lettersCnt, wordsScore;
	private static int[][] wordsCnt;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
		//각 주어진 단어 개수 세기
		lettersCnt = new int[26];
        answer = 0;
		for(char letter : letters) {
			lettersCnt[letter - 97]++; 
		}
		
		N = words.length; //단어의 개수
		wordsScore = new int[N];
		wordsCnt = new int[N][26];
		for(int i = 0; i < N; i++) {
			for(char word : words[i].toCharArray()) {
				wordsScore[i] += score[word - 97];
				wordsCnt[i][word - 97]++;
			}
		}
		
		selectWord(0, 0, new int[26], -1);
		return answer;
    }
	private void selectWord(int start, int sum, int[] selectedWord, int index) {
		boolean flag; int j;
		for(int i = start; i < N; i++) {
			flag = true;
			for(j = 0; j < 26; j++) {
				if(lettersCnt[j] < wordsCnt[i][j] + selectedWord[j]) {
					flag = false;
					break;
				}
				selectedWord[j] += wordsCnt[i][j];
			}

			if(flag) {
				selectWord(i + 1, sum + wordsScore[i], selectedWord, i);
			}
			while(--j >= 0) {
				selectedWord[j] -= wordsCnt[i][j];
			}
		}
		
		answer = Math.max(answer, sum);
	}
}