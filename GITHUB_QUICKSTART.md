# ⚡ Быстрый старт: Logic Assistant на GitHub за 5 минут

Все что нужно чтобы запустить мод на GitHub с CI/CD в 5 шагов!

## 🚀 Шаг 1: Создай репо на GitHub (1 минута)

1. Перейди на https://github.com/new
2. Введи:
   - **Repository name**: `logic-assistant-mod`
   - **Description**: `🤖 AI Copilot для Mindustry Logic Processor`
   - **Public** (публичный)
3. Нажми **Create repository**

## 📥 Шаг 2: Загрузи код (2 минуты)

Скопируй эти команды в терминал:

### Если нет локального гита

```bash
# Клонируй свой пустой репо
git clone https://github.com/твой-юзер/logic-assistant-mod.git
cd logic-assistant-mod

# Скопируй сюда все файлы проекта (src/, .github/, build.gradle и т.д.)
# Потом:

git add .
git commit -m "Initial: Logic Assistant Mod with CI/CD"
git push -u origin main
```

### Если уже есть локальный гит

```bash
cd твоя-папка-с-проектом
git remote add origin https://github.com/твой-юзер/logic-assistant-mod.git
git branch -M main
git push -u origin main
```

## ✅ Шаг 3: Проверь что CI/CD работает (1 минута)

1. Перейди на GitHub репо
2. Нажми вкладку **Actions**
3. Должны виднеться workflow'ы запущенными
4. Ждёшь зелёной галочки ✅

Если что-то красное ❌ - посмотри логи и исправь.

## 🏷️ Шаг 4: Создай первый релиз (1 минута)

```bash
# Создай тег (например версия 1.0.0)
git tag v1.0.0

# Загрузи тег
git push origin v1.0.0
```

GitHub Actions сам создаст релиз с JAR файлом! 🎉

## 🎯 Шаг 5: Готово! (используй)

Теперь каждый раз когда ты:

- **Push код** → автоматическая сборка ✅
- **Создаёшь тег** → автоматический релиз 🚀
- **Создаёшь PR** → автоматическая проверка качества 🔍

## 📋 Что у тебя есть сейчас

```
✅ Автоматическая сборка при каждом push
✅ Автоматический релиз при создании тага
✅ Проверка качества кода
✅ JAR файлы готовы для скачивания
✅ Полная документация
✅ GitHub Actions для CI/CD
```

## 🔄 Типичный рабочий процесс

```bash
# 1. Создай ветку для новой фичи
git checkout -b feature/новая-фишка

# 2. Делай коммиты
git add .
git commit -m "Добавил новую фичу"

# 3. Push
git push origin feature/новая-фишка

# 4. GitHub Actions автоматически собирает и проверяет

# 5. Создай Pull Request на GitHub
# (нажми "New Pull Request" на странице репо)

# 6. После merge в main - мерж может создавать релиз

# 7. Когда готов новая версия - создай тег
git checkout main
git pull
git tag v1.1.0
git push origin v1.1.0

# 8. GitHub Actions создаст релиз автоматически
```

## 📦 Структура которая нужна на GitHub

```
logic-assistant-mod/
├── .github/workflows/
│   ├── build.yml
│   ├── release.yml
│   └── code-quality.yml
├── src/main/java/ai/logicassistant/
│   ├── LogicAssistantMod.java
│   ├── LogicCodeGenerator.java
│   ├── LogicAssistantConfig.java
│   ├── ui/
│   ├── events/
│   └── patch/
├── build.gradle
├── settings.gradle
├── mod.hjson
├── .gitignore
└── README.md
```

## 🆘 Если что-то не работает

### GitHub Actions не запускается
```
→ Посмотри вкладку Actions
→ Нажми на workflow
→ Посмотри логи ошибок
→ Обычно это проблемы в build.gradle
```

### Релиз не создаётся
```
→ Проверь что тег в формате v1.2.3
→ git tag v1.0.0
→ git push origin v1.0.0
→ Подожди 30 секунд
→ Обнови страницу GitHub
```

### JAR файл не создаётся
```
→ Проверь логи build.yml в Actions
→ Убедись что Java 17+ установлена локально
→ Запусти ./gradlew build локально
```

## 🎓 Дальше изучи

После того как всё работает, прочитай подробные гайды:

- 📖 **[DEVELOPMENT.md](DEVELOPMENT.md)** - как разрабатывать
- 🔄 **[CI_CD_GUIDE.md](CI_CD_GUIDE.md)** - как работает автоматизация
- 📚 **[README-LOGIC-ASSISTANT.md](README-LOGIC-ASSISTANT.md)** - документация мода

## 🎉 Готово!

Теперь ты имеешь:
- ✅ Профессиональный GitHub репо
- ✅ Автоматическую сборку (CI)
- ✅ Автоматические релизы (CD)
- ✅ Готовый мод для скачивания

**Поздравляю! 🎊**

---

## 📞 Quick Links

| Ссылка | Назначение |
|--------|-----------|
| [GitHub репо](https://github.com/твой-юзер/logic-assistant-mod) | Основной репо |
| [Actions](https://github.com/твой-юзер/logic-assistant-mod/actions) | Статус сборок |
| [Releases](https://github.com/твой-юзер/logic-assistant-mod/releases) | Скачивание релизов |
| [Issues](https://github.com/твой-юзер/logic-assistant-mod/issues) | Баги и фичи |
| [Pull Requests](https://github.com/твой-юзер/logic-assistant-mod/pulls) | Изменения |

---

**Удачи! Если что-то непонятно - создай Issue на GitHub! 🚀**
