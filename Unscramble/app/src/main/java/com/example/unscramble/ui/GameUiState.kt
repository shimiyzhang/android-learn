package com.example.unscramble.ui

data class GameUiState(
    val currentScrambledWord: String = "", // 当前待猜单词
    val isGuessedWordWrong: Boolean = false, // 猜测结果
    val currentWordCount: Int = 1, // 第几个题目
    val score: Int = 0, // 得分
    val isGameOver: Boolean = false, // 是否结束
)