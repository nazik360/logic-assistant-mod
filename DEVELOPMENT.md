# 🚀 Разработка Logic Assistant Mod

Руководство для разработчиков, которые хотят внести вклад в проект.

## 📋 Требования

- **Java 17+** (можешь скачать с [adoptium.net](https://adoptium.net))
- **Gradle 8.0+** (обычно идёт с проектом)
- **Mindustry 159.7+** для тестирования
- **Git** для работы с репозиторием

## 🛠️ Локальная установка

### 1. Клонируй репозиторий

```bash
git clone https://github.com/твой-юзер/logic-assistant-mod.git
cd logic-assistant-mod
```

### 2. Проверь Java

```bash
java -version
# Должно быть 17 или выше
```

### 3. Собери проект

```bash
./gradlew build
```

Или на Windows:

```bash
gradlew.bat build
```

### 4. Установи локально

```bash
./gradlew deployLocal
```

Это скопирует JAR в папку модов Mindustry.

## 📁 Структура проекта

```
logic-assistant-mod/
├── .github/
│   └── workflows/           # GitHub Actions
│       ├── build.yml        # Главная сборка
│       ├── release.yml      # Создание релизов
│       └── code-quality.yml # Проверка качества
├── src/main/java/
│   └── ai/logicassistant/
│       ├── LogicAssistantMod.java
│       ├── LogicCodeGenerator.java
│       ├── LogicAssistantConfig.java
│       ├── ui/              # Пользовательский интерфейс
│       ├── events/          # Слушатели событий
│       └── patch/           # Патчинг компонентов
├── build.gradle             # Конфиг сборки
├── settings.gradle          # Настройки проекта
├── mod.hjson               # Конфиг мода
└── README.md               # Основная документация
```

## 🔧 Команды Gradle

### Основные команды

```bash
# Собрать мод
./gradlew build

# Установить локально
./gradlew deployLocal

# Полная сборка и установка
./gradlew fullBuild

# Очистить артефакты
./gradlew clean

# Показать информацию о проекте
./gradlew printInfo
```

### Проверка качества кода

```bash
# Проверить формат
./gradlew spotlessCheck

# Исправить формат
./gradlew spotlessApply

# Проверить зависимости
./gradlew dependencies
```

## 📝 Как вносить изменения

### 1. Создай ветку

```bash
git checkout -b feature/твоя-фишка
# или для исправления бага
git checkout -b bugfix/баг-который-ты-чинишь
```

### 2. Внеси изменения

Редактируй файлы в папке `src/main/java/ai/logicassistant/`

### 3. Тестируй локально

```bash
./gradlew fullBuild
# Запусти Mindustry и проверь что работает
```

### 4. Проверь качество кода

```bash
./gradlew spotlessCheck
./gradlew build
```

### 5. Закоммить изменения

```bash
git add .
git commit -m "Краткое описание изменений"
```

### 6. Push в свою ветку

```bash
git push origin feature/твоя-фишка
```

### 7. Создай Pull Request на GitHub

На странице репо нажми "New Pull Request" и опиши свои изменения.

## 🤖 GitHub Actions CI/CD

Когда ты push-ишь код или создаёшь PR, автоматически:

1. **Собирается** проект через Gradle
2. **Проверяется** качество кода
3. **Создаётся** артефакт (JAR файл)

Результаты можно посмотреть в табе **Actions** на GitHub.

### Автоматические релизы

Когда ты создаёшь тег (tag) вроде `v1.0.0`:

1. GitHub Actions собирает мод
2. Создаёт релиз на GitHub
3. Загружает JAR в релиз
4. Генерирует changelog из коммитов

**Как создать релиз:**

```bash
git tag v1.1.0
git push origin v1.1.0
```

GitHub Actions сделает всё остальное!

## 🐛 Отладка

### Логирование

Используй `Log` из Mindustry:

```java
import arc.util.Log;

Log.info("[Logic Assistant] Сообщение");
Log.warn("[Logic Assistant] Предупреждение");
Log.err("[Logic Assistant] Ошибка");
```

### Проверка конфига

```bash
# Конфиг хранится в:
~/.local/share/Mindustry/config/logic-assistant-config.json
```

### Просмотр логов в игре

В Mindustry нажми `~` и введи `logs` чтобы открыть логи.

## 📚 Полезная информация

### Документация

- [Mindustry Logic](https://mindustry.fandom.com/wiki/Logic)
- [Mindustry Wiki](https://mindustry.fandom.com/)
- [Arc Documentation](https://github.com/Anuken/Arc)
- [Anthropic API Docs](https://docs.anthropic.com/)

### Инструменты

- **IDE**: IntelliJ IDEA (Community Edition)
- **Gradle**: Встроен в проект
- **Git**: https://git-scm.com

## 🎯 Идеи для улучшений

Вот что можно сделать:

- [ ] История сгенерированных кодов
- [ ] Сохранение частых запросов (шаблоны)
- [ ] Редактор мlog с синтаксис-highlighting
- [ ] Примеры кода на экране помощи
- [ ] Поддержка других языков
- [ ] Интеграция с Discord для уведомлений
- [ ] Локальный кеш сгенерированного кода
- [ ] Больше примеров в документации

## 🔒 Кодовые стандарты

1. **Форматирование**: Google Java Format (проверяется автоматически)
2. **Комментарии**: На английском в коде, объяснения на русском в документации
3. **Имена переменных**: camelCase на английском
4. **Импорты**: Убирай неиспользуемые (spotlessApply сделает это)

## 📞 Помощь

Если нужна помощь:

1. Посмотри [Issues](../../issues) - может уже кто-то спрашивал
2. Создай новый Issue с подробным описанием
3. Напиши в Discord если есть сервер проекта

## ✅ Checklist перед Push

Перед тем как push-ить, проверь:

- [ ] Код собирается без ошибок: `./gradlew build`
- [ ] Качество кода в норме: `./gradlew spotlessCheck`
- [ ] Тестировал локально в Mindustry
- [ ] Написал комментарии к сложным местам
- [ ] Обновил документацию если нужно
- [ ] Создал PR с описанием изменений

## 🎉 Спасибо за вклад!

Каждый вклад делает Logic Assistant лучше! 

---

**Вопросы? Создай Issue или напиши в чате!** 💬
