package sample;
import javafx.concurrent.Task;

public class LoginTask extends Task<Boolean> {

    @Override
    protected Boolean call() throws Exception {
        // هنا قلنا أنه سيتم إيقاف تنفيذ هذه المهمة لمدة ثانيتين
        Thread.sleep(2000);
        // الذي سنربطه بكائن من هذا الكلاس يظهر مكتملاً ProgressIndicator بعد إنقضاء الثانيتين سنجعل قيمة الـ
        updateProgress(1, 1);
        // و هذا ليس له أي أثر على البرنامج Boolean لأننا قمنا بتعريفها كـ true هنا جعلنا الدالة ترجع القيمة
        return true;
    }




}
