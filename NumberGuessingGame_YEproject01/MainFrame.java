package NumberGuessingGame_YEproject01;

import java.util.Random;
import java.util.Scanner;
/**
 数字当てゲーム（Number Guessing Game）
 * 1から100までの範囲で生成された乱数を、ユーザーが推測して当てるコンソールアプリケーションです。
 *
 * 【設計意図 / Design Intent】
 *本クラスは数当てゲームの最小構成として、
 *・制御フロー（while / if-else）
 *・ユーザー入力
 *・状態管理（試行回数）
 *を一つの処理フローとして集約し、シンプルな構成で動作することを前提としている。
 *
 * @author ye888000
 * @version 1.0
 * @since 2026-02-03
 */

public class MainFrame {

    public static void main(String[] args) {

        //正解となる数値は 1〜100 の範囲に限定する。
        //範囲を明示することで、ユーザー入力と判定条件を単純化している。
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        //動作確認時のみ一時的に有効化する想定。
        // System.out.println("Random number is " + randomNumber);

        Scanner scanner = new Scanner(System.in);

        //tryCount はユーザーの試行回数を管理する。
        int tryCount = 0;

        //正解するまで処理を継続するため、無限ループを採用している。
        //終了条件は break によって明示的に制御する。
        while (true) {
            System.out.println("予想した数字を入力してください(1-100):");
            //本実装では整数値が入力されることを前提としている
            int playerGuess = scanner.nextInt();
            tryCount++;

            //【判定ロジック】
            //・一致：ゲーム終了   ・不一致：ヒントを表示して再入力
            //判定条件を単純な大小比較にすることで、処理の可読性を優先している。
            if (playerGuess == randomNumber) {
                System.out.println("正解です！あなたの勝ちです！");
                System.out.println( tryCount + "回試しました");
                break;
            } else if (randomNumber > playerGuess) {
                System.out.println("いいえ、正解はこの数字よりも大きいです。もう一度試してみてください。");
            } else {
                System.out.println("いいえ、正解はこの数字よりも小さいです。もう一度試してみてください。");
            }
        }
    }
}

//