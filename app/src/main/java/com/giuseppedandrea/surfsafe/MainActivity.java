/**
 * Nome App: SurfSafe
 * Autore: Giuseppe D'Andrea
 */

package com.giuseppedandrea.surfsafe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creazione all'interno del textSwitcherTip di una TextView
        TextSwitcher textSwitcherTip = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTip.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                TextView textViewTip = new TextView(MainActivity.this);
                textViewTip.setTextSize(14);
                //Impostazione testo di default (al caricamento dell'app)
                textViewTip.setText(R.string.textViewTipZero);
                return textViewTip;
            }
        });

        //Creazione all'interno dell'imageSwitcherTip di una ImageView
        ImageSwitcher imageSwitcherTip = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTip.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView imageViewTip = new ImageView(MainActivity.this);
                imageViewTip.setContentDescription(getString(R.string.imageViewTip));
                //Impostazione immagine di default (al caricamento dell'app)
                imageViewTip.setImageResource(R.drawable.tip_zero);
                imageViewTip.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return imageViewTip;
            }
        });

        //Caricamento animazioni di entrata e uscita
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        //Impostazione animazione di entrata e usicta del textSwitcherTip
        textSwitcherTip.setInAnimation(in);
        textSwitcherTip.setOutAnimation(out);

        //Impostazione animazione di entrata e usicta dell'imageSwitcherTip
        imageSwitcherTip.setInAnimation(in);
        imageSwitcherTip.setOutAnimation(out);
    }

    /**
     * Questo metodo viene chiamato quando il bottone #1 viene cliccato
     */
    public void onClickTipOne(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(true, false);

        //Controllo se il bottone #1 è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipOne = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipOne.getText().toString().equals(getString(R.string.textViewNumberTipOne))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipOne.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #1
        Button buttonTipOne = (Button) findViewById(R.id.buttonTipOne);
        buttonTipOne.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #1
        textViewNumberTipOne.setText(R.string.textViewNumberTipOne);
        //Impostazione testo textSwitcherTip per il bottone #1
        TextSwitcher textSwitcherTipOne = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipOne.setText(getString(R.string.textViewTipOne));
        //Impostazione immagine imageSwitcherTip per il bottone #1
        ImageSwitcher imageSwitcherTipOne = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipOne.setImageResource(R.drawable.tip_one);

        //Reset TextViewPasswords per permettere generazione nuove password
        TextView textViewCleanPasswords = (TextView) findViewById(R.id.textViewPasswords);
        textViewCleanPasswords.setText("");
    }

    /**
     * Questo metodo viene chiamato quando il bottone #2 viene cliccato
     */
    public void onClickTipTwo(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(false, false);

        //Controllo se il bottone #2 è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipTwo = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipTwo.getText().toString().equals(getString(R.string.textViewNumberTipTwo))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipTwo.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #2
        Button buttonTipTwo = (Button) findViewById(R.id.buttonTipTwo);
        buttonTipTwo.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #2
        textViewNumberTipTwo.setText(R.string.textViewNumberTipTwo);
        //Impostazione testo textSwitcherTip per il bottone #2
        TextSwitcher textSwitcherTipTwo = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipTwo.setText(getString(R.string.textViewTipTwo));
        //Impostazione immagine imageSwitcherTip per il bottone #2
        ImageSwitcher imageSwitcherTipTwo = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipTwo.setImageResource(R.drawable.tip_two);
    }

    /**
     * Questo metodo viene chiamato quando il bottone #3 viene cliccato
     */
    public void onClickTipThree(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(false, false);

        //Controllo se il bottone #3 è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipThree = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipThree.getText().toString().equals(getString(R.string.textViewNumberTipThree))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipThree.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #3
        Button buttonTipThree = (Button) findViewById(R.id.buttonTipThree);
        buttonTipThree.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #3
        textViewNumberTipThree.setText(R.string.textViewNumberTipThree);
        //Impostazione testo textSwitcherTip per il bottone #3
        TextSwitcher textSwitcherTipThree = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipThree.setText(getString(R.string.textViewTipThree));
        //Impostazione immagine imageSwitcherTip per il bottone #3
        ImageSwitcher imageSwitcherTipThree = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipThree.setImageResource(R.drawable.tip_three);
    }

    /**
     * Questo metodo viene chiamato quando il bottone #4 viene cliccato
     */
    public void onClickTipFour(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(false, false);

        //Controllo se il bottone #4 è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipFour = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipFour.getText().toString().equals(getString(R.string.textViewNumberTipFour))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipFour.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #4
        Button buttonTipFour = (Button) findViewById(R.id.buttonTipFour);
        buttonTipFour.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #4
        textViewNumberTipFour.setText(R.string.textViewNumberTipFour);
        //Impostazione testo textSwitcherTip per il bottone #4
        TextSwitcher textSwitcherTipFour = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipFour.setText(getString(R.string.textViewTipFour));
        //Impostazione immagine imageSwitcherTip per il bottone #4
        ImageSwitcher imageSwitcherTipFour = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipFour.setImageResource(R.drawable.tip_four);
    }

    /**
     * Questo metodo viene chiamato quando il bottone #5 viene cliccato
     */
    public void onClickTipFive(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(false, false);

        //Controllo se il bottone #5 è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipFive = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipFive.getText().toString().equals(getString(R.string.textViewNumberTipFive))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipFive.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #5
        Button buttonTipFive = (Button) findViewById(R.id.buttonTipFive);
        buttonTipFive.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #5
        textViewNumberTipFive.setText(R.string.textViewNumberTipFive);
        //Impostazione testo textSwitcherTip per il bottone #5
        TextSwitcher textSwitcherTipFive = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipFive.setText(getString(R.string.textViewTipFive));
        //Impostazione immagine imageSwitcherTip per il bottone #5
        ImageSwitcher imageSwitcherTipFive = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipFive.setImageResource(R.drawable.tip_five);
    }

    /**
     * Questo metodo viene chiamato quando il bottone #... viene cliccato
     */
    public void onClickTipOther(View view) {
        //Imposta visibilità linearLayoutPasswordGenerator e linearLayoutSendTips.
        setVisibilityView(false, true);

        //Controllo se il bottone #... è già stato premuto. Se si, viene mostrato un Toast di avviso e return.
        TextView textViewNumberTipOther = (TextView) findViewById(R.id.textViewNumberTip);
        if (textViewNumberTipOther.getText().toString().equals(getString(R.string.textViewNumberTipOther))) {
            Toast.makeText(this, getString(R.string.numberTipError, textViewNumberTipOther.getText().toString().split("\n")), Toast.LENGTH_SHORT).show();
            return;
        }

        //Reset background di default dei bottoni
        resetButtonBackground();
        //Imposto il backgroud selected per il bottone #...
        Button buttonTipOther = (Button) findViewById(R.id.buttonTipOther);
        buttonTipOther.setBackgroundResource(R.drawable.button_selected);

        //Impostazione testo TextViewNumberTip per il bottone #...
        textViewNumberTipOther.setText(R.string.textViewNumberTipOther);
        //Impostazione testo textSwitcherTip per il bottone #...
        TextSwitcher textSwitcherTipOther = (TextSwitcher) findViewById(R.id.textSwitcherTip);
        textSwitcherTipOther.setText(getString(R.string.textViewTipOther));
        //Impostazione immagine imageSwitcherTip per il bottone #...
        ImageSwitcher imageSwitcherTipOTher = (ImageSwitcher) findViewById(R.id.imageSwitcherTip);
        imageSwitcherTipOTher.setImageResource(R.drawable.tip_other);
    }

    /**
     * Questo metodo imposta la visibilità di due LinearLayout:
     * - linearLayoutPasswordGenerator;
     * - linearLayoutSendTips.
     * Questi layout deve essere resi visibili (VISIBLE) solo in determinate
     * situazioni:
     * - Quando viene premuto il bottone #1 deve essere visibile (VISIBLE) il linearLayoutPasswordGenerator e
     * invisibili (GONE), se visibile, il linearLayoutSendTips;
     * - Quando viene premuto il bottone #... deve essere visibile (VISIBLE) il linearLayoutSendTips e
     * invisibili (GONE), se visibile, il linearLayoutPasswordGenerator.
     * In tutte le altre situazioni questi due layout devono essere invisibili (GONE).
     * @param  linearLayoutPasswordGenerator Se "true" rendere visibile (VISIBLE) il linearLayoutPasswordGenerator
     *                                       altrimenti, se "false", rendere invisibile (GONE) il linearLayoutPasswordGenerator
     * @param  linearLayoutSendTips Se "true" rendere visibile (VISIBLE) il linearLayoutSendTips
     *                              altrimenti, se "false", rendere invisibile (GONE) il linearLayoutSendTips
     */
    private void setVisibilityView(boolean linearLayoutPasswordGenerator, boolean linearLayoutSendTips) {
        LinearLayout passwordGenerator = (LinearLayout) findViewById(R.id.linearLayoutPasswordGenerator);
        if (linearLayoutPasswordGenerator)
            passwordGenerator.setVisibility(View.VISIBLE);
        else
            passwordGenerator.setVisibility(View.GONE);
        LinearLayout sendTips = (LinearLayout) findViewById(R.id.linearLayoutSendTips);
        if (linearLayoutSendTips)
            sendTips.setVisibility(View.VISIBLE);
        else
            sendTips.setVisibility(View.GONE);
    }

    /**
     * Questo metodo resetta il background di default di ogni bottone ogni volta che viene
     * premuto un differente bottone del menù dei consigli.
     */
    private void resetButtonBackground() {
        Button buttonTipOne = (Button) findViewById(R.id.buttonTipOne);
        buttonTipOne.setBackgroundResource(R.drawable.button);
        Button buttonTipTwo = (Button) findViewById(R.id.buttonTipTwo);
        buttonTipTwo.setBackgroundResource(R.drawable.button);
        Button buttonTipThree = (Button) findViewById(R.id.buttonTipThree);
        buttonTipThree.setBackgroundResource(R.drawable.button);
        Button buttonTipFour = (Button) findViewById(R.id.buttonTipFour);
        buttonTipFour.setBackgroundResource(R.drawable.button);
        Button buttonTipFive = (Button) findViewById(R.id.buttonTipFive);
        buttonTipFive.setBackgroundResource(R.drawable.button);
        Button buttonTipOther = (Button) findViewById(R.id.buttonTipOther);
        buttonTipOther.setBackgroundResource(R.drawable.button);
    }

    /**
     * Questo metodo viene chiamato quando il bottone GeneratePassword viene cliccato, possibile
     * solamente se il linearLayoutPasswordGenerator è visibile (VISIBLE)
     */
    public void onClickGeneratePassword(View view) {
        //Controllo se l'EditTextLegnht è vuota. Se si, viene mostrato un Toast di avviso e return.
        EditText editTextLenght = (EditText) findViewById(R.id.editTextLenght);
        String stringLenght = editTextLenght.getText().toString();
        if (stringLenght.equals("")) {
            Toast.makeText(this, getString(R.string.generalError, getString(R.string.textViewLenght).split(":")), Toast.LENGTH_SHORT).show();
            return;
        }
        //Controllo che il numero digitato nell'EditTextLenght sia compreso tra 4 e 32. Se no, viene mostrato un Toast di avviso e return.
        int lenght = Integer.parseInt(stringLenght);
        int lenghtMin = 8;
        int lenghtMax = 32;
        if (lenght < lenghtMin || lenght > lenghtMax) {
            Toast.makeText(this, getString(R.string.lenghtError, lenghtMin, lenghtMax), Toast.LENGTH_SHORT).show();
            return;
        }

        //Controllo se l'EditTextQuantity è vuota. Se si, viene mostrato un Toast di avviso e return.
        EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);
        String stringQuantity = editTextQuantity.getText().toString();
        if (stringQuantity.equals("")) {
            Toast.makeText(this, getString(R.string.generalError, getString(R.string.textViewQuantity).split(":")), Toast.LENGTH_SHORT).show();
            return;
        }
        //Controllo che il numero digitato nell'EditTextQuantity sia compreso tra 1 e 10. Se no, viene mostrato un Toast di avviso e return.
        int quantity = Integer.parseInt(stringQuantity);
        int quantityMin = 1;
        int quantityMax = 10;
        if (quantity < quantityMin || quantity > quantityMax) {
            Toast.makeText(this, getString(R.string.quantityError, quantityMin, quantityMax), Toast.LENGTH_SHORT).show();
            return;
        }

        //Salvataggio checkagio checkBoxLetters, checkBoxUpperLowerCase, checkBoxNumbers e checkBoxSpecialCharacters.
        CheckBox checkBoxLetters = (CheckBox) findViewById(R.id.checkBoxLetters);
        boolean isCheckedLetters = checkBoxLetters.isChecked();
        CheckBox checkBoxUpperLowerCase = (CheckBox) findViewById(R.id.checkBoxUpperLowerCase);
        boolean isCheckedUpperLowerCase = checkBoxUpperLowerCase.isChecked();
        CheckBox checkBoxNumbers = (CheckBox) findViewById(R.id.checkBoxNumbers);
        boolean isCheckedNumbers = checkBoxNumbers.isChecked();
        CheckBox checkBoxSpecialCharacters = (CheckBox) findViewById(R.id.checkBoxSpecialCharacters);
        boolean isCheckedSpecialCharacters = checkBoxSpecialCharacters.isChecked();

        if(!isCheckedLetters && !isCheckedUpperLowerCase && !isCheckedNumbers && !isCheckedSpecialCharacters)
        {
            Toast.makeText(this, getString(R.string.allCheckBoxError), Toast.LENGTH_SHORT).show();
            return;
        }

        //Creazione charset in base ai check impostati dall'utente.
        String charset = "";
        if (isCheckedLetters)
            charset += "abcdefghijklmnopqrstuvwxyz";
        if (isCheckedUpperLowerCase)
            charset += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (isCheckedNumbers)
            charset += "0123456789";
        if (isCheckedSpecialCharacters)
            charset += " !\"#$%&'()*+,-./";

        //Visualizzazione password, generate tramite il metodo GeneratePassword, nella TextViewPasswords.
        TextView textViewPasswords = (TextView) findViewById(R.id.textViewPasswords);
        textViewPasswords.setText(GeneratePassword(lenght, quantity, charset));
    }

    /**
     * Questo metodo genera una password casuale utilizzano determinati charset
     * selezionati dall'utente.
     * L'utente imposta sia la lunghezza che il numero di password da generare che
     * vengono passati al metodo tramite parametri.
     * @param lenght Lunghezza della password
     * @param quantity Numero di password da generare
     * @return passwords Stringa contenente le passwords generate
     */
    private String GeneratePassword(int lenght, int quantity, String charset)
    {
        //Ottenere numero caratteri nel charset
        int lenghtCharset = charset.length();
        //Inizializzazione stringa password con un titolo.
        String passwords = getString(R.string.textViewPasswords);
        //Ripetizione generazione password in base alla quantità impostata dall'utente
        for (int i = 0; i < quantity; i++) {
            //Generazione password di lunghezza impostata dall'utente
            for (int j = 0; j < lenght; j++) {
                //Generazione carattere random dal charset
                Random random = new Random();
                int index = random.nextInt(lenghtCharset);
                //Concatenamento caratteri password
                passwords += charset.charAt(index);
            }
            passwords += '\n';
        }
        return passwords;
    }

    /**
     * Questo metodo viene chiamato quando il bottone Submit viene cliccato, possibile
     * solamente se il linearLayoutSendTips è visibile (VISIBLE)
     */
    public void onClickSubmit(View view) {
        //Controllo se l'EditTextName è vuota. Se si, viene mostrato un Toast di avviso e return.
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();
        if (name.equals("")) {
            Toast.makeText(this, getString(R.string.generalError, getString(R.string.textViewName)), Toast.LENGTH_SHORT).show();
            return;
        }

        //Controllo se l'EditTextMessage è vuota. Se si, viene mostrato un Toast di avviso e return.
        EditText editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        String message = editTextMessage.getText().toString();
        if (message.equals("")) {
            Toast.makeText(this, getString(R.string.generalError, getString(R.string.textViewMessage)), Toast.LENGTH_SHORT).show();
            return;
        }

        //Generazione Intent per mandare via mail (ACTION_SENDTO) il messaggio scritto dall'utente
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:giuseppe.dandrea19@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.messageSubject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}