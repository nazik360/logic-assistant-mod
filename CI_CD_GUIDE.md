# 🔄 CI/CD Pipeline для Logic Assistant Mod

Полное руководство по автоматизации сборки, тестирования и релизов через GitHub Actions.

## 📊 Что такое CI/CD?

- **CI (Continuous Integration)** - автоматическая сборка и тестирование при каждом push'е
- **CD (Continuous Deployment)** - автоматический релиз при создании тага

## 🏗️ Архитектура Pipeline'а

```
┌─────────────────┐
│   Git Push      │
└────────┬────────┘
         │
    ┌────▼─────┐
    │   GitHub │
    └────┬─────┘
         │
    ┌────▼────────────────────────┐
    │   GitHub Actions Trigger    │
    └────┬───────────────────────┬┘
         │                       │
    ┌────▼──────────┐   ┌───────▼──────────┐
    │ Build Workflow│   │Release Workflow  │
    │ (постоянно)   │   │(при тага v*.*.*)│
    └────┬──────────┘   └───────┬──────────┘
         │                      │
    ┌────▼──────────────┐   ┌──▼──────────────┐
    │ 1. Checkout код   │   │ 1. Checkout код │
    │ 2. Setup Java 17  │   │ 2. Setup Java 17│
    │ 3. Build Gradle   │   │ 3. Build Gradle │
    │ 4. Run tests      │   │ 4. Generate log │
    │ 5. Upload JAR     │   │ 5. Create Release
    │ 6. Notify         │   │ 6. Upload JAR   │
    └───────────────────┘   └─────────────────┘
```

## 📁 Файлы Workflow'ов

### `.github/workflows/build.yml`

**Запускается:** при каждом push в `main` или `develop`

**Этапы:**
1. ✅ Проверка кода из репо
2. ✅ Установка Java 17
3. ✅ Сборка через Gradle
4. ✅ Загрузка JAR в артефакты
5. ✅ (Опционально) создание релиза при тага

**Результат:** JAR файл доступен в разделе Actions

### `.github/workflows/release.yml`

**Запускается:** при создании тага `v*.*.*` (например: `v1.0.0`)

**Этапы:**
1. ✅ Проверка кода
2. ✅ Сборка мода
3. ✅ Генерация changelog'а из коммитов
4. ✅ Создание GitHub Release
5. ✅ Загрузка JAR в релиз
6. ✅ Отправка уведомления в Discord (если настроено)

**Результат:** Новый релиз на странице Releases с JAR файлом

### `.github/workflows/code-quality.yml`

**Запускается:** при каждом push и PR

**Проверяет:**
- ✅ Формат кода (Google Java Format)
- ✅ Размер JAR (< 10MB)
- ✅ Зависимости
- ✅ Отсутствие ошибок

## 🚀 Как использовать

### Обычная разработка

```bash
# Создай ветку
git checkout -b feature/мы-фишка

# Делай коммиты
git add .
git commit -m "Добавил новую фичу"

# Push
git push origin feature/моя-фишка

# GitHub Actions автоматически:
# ✅ Собирает код
# ✅ Проверяет качество
# ✅ Создаёт артефакт JAR
```

### Создание релиза

```bash
# Убедись что всё скоммичено
git status

# Создай тег
git tag v1.0.0

# Push тага
git push origin v1.0.0

# GitHub Actions сделает:
# ✅ Собирает JAR
# ✅ Генерирует changelog
# ✅ Создаёт GitHub Release
# ✅ Загружает JAR в релиз
# ✅ Отправляет уведомление в Discord (если настроено)
```

## 📊 Мониторинг статуса

### Просмотр статуса сборок

1. Перейди на GitHub репо
2. Нажми вкладку **Actions**
3. Увидишь список всех запусков workflow'ов
4. Нажми на запуск чтобы посмотреть детали
5. Посмотри логи в конкретных шагах

### Статус бейджи для README

Добавь в README.md:

```markdown
[![Build Status](https://github.com/твой-юзер/logic-assistant-mod/actions/workflows/build.yml/badge.svg)](https://github.com/твой-юзер/logic-assistant-mod/actions)
```

## ⚙️ Конфигурация

### Изменение версии

Отредактируй `build.gradle`:

```gradle
version = '1.0.1'  // Измени версию здесь
```

### Изменение минимальной версии Mindustry

```gradle
compileOnly "com.github.Anuken.Mindustry:core:v159.7"  // Измени версию
```

### Добавление новых зависимостей

В `build.gradle` в блоке `dependencies`:

```gradle
dependencies {
    compileOnly "com.github.Anuken.Mindustry:core:v159.7"
    compileOnly "com.github.Anuken.Arc:arc-core:v159.7"
    
    // Добавь сюда новые зависимости
    compileOnly "other.library:name:version"
}
```

### Discord уведомления при релизе (опционально)

1. В GitHub репо: **Settings** → **Secrets and variables** → **Actions**
2. **New repository secret**:
   - **Name**: `DISCORD_WEBHOOK`
   - **Value**: `https://discordapp.com/api/webhooks/ID/TOKEN`
3. Сохрани

Теперь при релизе автоматически отправится уведомление в Discord канал!

## 🐛 Troubleshooting

### Build failed (сборка не удалась)

**Решение:**
1. Посмотри логи в Actions
2. Проверь что все зависимости в `build.gradle` верные
3. Убедись что Java 17+ установлена
4. Попробуй локально: `./gradlew build`

### Release не создаёт JAR

**Проверь:**
- Тег в формате `v1.2.3` (с буквой v)
- `build.gradle` правильно настроен
- Нет синтаксических ошибок в коде

### GitHub Actions медленно запускается

**Обычно:**
- Первый запуск медленнее (кешируется Gradle)
- Нормально что идёт 5-10 минут

## 📈 Метрики и статистика

GitHub Actions показывает:

```
✅ Total runs: 42
✅ Successful: 40
⚠️  Failed: 2
⏱️  Avg duration: 4m 30s
```

## 🔐 Безопасность

**GitHub Actions уже:**
- ✅ Защищает API ключи (Secrets)
- ✅ Изолирует каждый запуск
- ✅ Логирует все действия
- ✅ Проверяет целостность кода

## 📚 Примеры Workflow'ов

### Пример: сборка в 5 минут

```yaml
# .github/workflows/quick-build.yml
name: Quick Build
on: push
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: gradle
      - run: chmod +x gradlew && ./gradlew build --no-daemon
```

### Пример: тестирование перед релизом

```yaml
# .github/workflows/test-before-release.yml
name: Test Before Release
on:
  pull_request:
    branches: [main]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - run: chmod +x gradlew
      - run: ./gradlew test --no-daemon
```

## 🎯 Best Practices

1. **Коммиты**: Маленькие и частые (легче находить баги)
2. **Сообщения**: Понятные (что изменилось и почему)
3. **Теги**: Семантическое версионирование (v1.2.3)
4. **Ветки**: feature/новая-фишка, bugfix/баг-название
5. **Pull Requests**: Описывай что и почему сделал

## 📞 Полезные команды

```bash
# Посмотри все теги
git tag

# Удали локальный тег
git tag -d v1.0.0

# Удали удалённый тег
git push origin :refs/tags/v1.0.0

# Перечитай последний тег
git checkout v1.0.0

# Создай новый тег из старого коммита
git tag v1.0.1 abc123def

# Покажи информацию о теге
git show v1.0.0
```

## 🎉 Результат

После настройки CI/CD ты получишь:

✅ **Автоматическую сборку** - каждый push проверяется
✅ **Качество кода** - все ошибки ловятся до релиза
✅ **Автоматические релизы** - просто создай тег
✅ **История версий** - все релизы на GitHub
✅ **JAR для скачивания** - пользователи скачивают готовый мод
✅ **Уведомления** - знаешь что происходит в проекте

---

**Теперь ты готов к профессиональной разработке! 🚀**
