Ausrichtung

```html
    <div class="answer-calls"></div>
    <div class="type-message"></div>
    <div class="upload-image"></div>
    <div class="participants"></div>
```

Sprachliche Angleichung (Action, Singular):

```html
    <div class="answer-call"></div>
    <div class="type-message"></div>
    <div class="upload-image"></div>
    <div class="show-participant"></div>
```

Von der Action zum Button:

```html
    <div class="answer-calls-button"></div>
    <div class="type-message-button"></div>
    <div class="upload-image-button"></div>
    <div class="show-participants-button"></div>
```

Konsistent aber nicht "aligned". Also vierter Versuch mit Bruch des Action-Name-Button-Schemas:

```html
    <div class="answer-calls-button"></div>
    <div class="type-message-button"></div>
    <div class="upload-image-button"></div>
    <div class="participants-button"></div>
```

Selber Prefix:

```html
    <div class="button-answer-calls"></div>
    <div class="button-type-message"></div>
    <div class="button-upload-image"></div>
    <div class="button-participants"></div>
```

Korrekterweise (Achtung auf genaue Action):

```html
    <div class="button-answer-calls"></div>
    <div class="button-type-message"></div>
    <div class="button-upload-images"></div>
    <div class="button-show-participants"></div>
```

Für Button Styling eignen sich verbindende Klassen:

```html
    <div class="button answer-calls"></div>
    <div class="button type-message"></div>
    <div class="button upload-images"></div>
    <div class="button show-participants"></div>
```

Habe mich für die letzte Variante entschieden, da ein Container-Element eh mehr Elemente rein bekommt und man dann das Alignment nicht mehr sieht. Außerdem geht es nicht darum Code auf einer Kante auszurichten, sondern darum, syntaktisch korrekt zu bleiben und ein Schema zu haben, das konsistent ist.

