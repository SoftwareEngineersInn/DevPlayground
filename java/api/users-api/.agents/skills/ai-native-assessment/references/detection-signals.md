# Detection Signals

This reference defines the filesystem signals, config files, CLI tools, and artifacts to look for when identifying AI-native primitives in a repository. Use it during step 1 of the assessment workflow.

---

## Spec-Driven Development Detection

> **Any spec-driven development framework is enough.** The goal is to detect *whether* the repo uses an SDD workflow at all -- not to find a specific tool. OpenSpec, SpecKit, BMAD (BMAD-METHOD), GSD (Git. Ship. Done.), a homegrown spec process, or any other SDD system count equally. The layouts below are recognition aids, not requirements: a repo that runs a different SDD framework still qualifies as long as it has real planning/specification artifacts that are actively used.

Detect whether the repository uses a spec-driven development system. Any recognized system counts equally -- the rubric does not favor one tool over another. Detection only establishes *that* a system is present and *how mature* its usage is; it never awards a higher ceiling to a particular tool, command set, artifact vocabulary, or directory layout.

Different systems organize their files differently, and a mature repository may express the same maturity through very different structures. Score the *substance* (planning artifacts exist, are complete, and are actively used), not a specific tool's file names or folder layout.

Recognized spec system layouts (treated as equivalent indicators):

| Layout | Example system | Notes |
|--------|---------------|-------|
| `openspec/` (with `changes/`, `specs/`) | OpenSpec | Work items live under `changes/`; completed work is moved into an `archive/` subdirectory. |
| `.specify/` (with `memory/`, `templates/`, `scripts/`) plus `specs/<id>-<name>/` feature directories | SpecKit | Per-feature artifacts live under `specs/`; it does not use an archive directory, so judge completion from the artifacts on disk (e.g., a status field or a fully checked task list). |
| `_bmad/` (with `core/`, `bmm/`) plus `_bmad-output/` (V6); or `.bmad-core/` / `bmad-core/` / `.bmad-method/` (V4) | BMAD (BMAD-METHOD) | Planning artifacts live under `_bmad-output/planning-artifacts/` (e.g., `prd.md`, `architecture.md`, `epics/`) or `docs/`; story/sprint status is tracked in `_bmad-output/implementation-artifacts/sprint-status.yaml`. Output paths are configurable, so confirm by inspecting the files. |
| `.planning/` (with `STATE.md`, `ROADMAP.md`, `config.json`) plus a `phases/<NN-slug>/` subtree | GSD (Git. Ship. Done.) | Per-phase work lives under `.planning/phases/<NN-slug>/` with `*-PLAN.md`, `*-VERIFICATION.md`, etc. Completion shows on disk as a phase `VERIFICATION.md` with `status: passed`, entries in `.planning/MILESTONES.md`, or archived phase directories under `.planning/milestones/v{X.Y}-phases/`. |
| `specs/` containing planning/change artifacts | Generic / other spec-driven workflow | A bare `specs/` may also hold OpenAPI specs, test specs, or unrelated content -- inspect before scoring. |

If no recognized spec layout exists and no spec CLI or workflow command is present, Spec-Driven Development scores 0 across all sub-metrics.

> Note: A bare `specs/` directory is ambiguous -- it may hold OpenAPI specs, test specs, or unrelated content. Inspect its contents and only treat it as a spec-driven development system when it contains planning or specification artifacts. This caution is about evidence quality, not tool preference. SpecKit legitimately uses `specs/` as its primary artifact location, so do not discount a `specs/` directory that contains real planning artifacts.

### Primary Signals (any confirms a spec system is present)

| Signal | What to check |
|--------|--------------|
| Spec system directory | A recognized spec layout exists at repo root (e.g., `openspec/`, `.specify/`, `_bmad/`, `.planning/`, or a `specs/` directory holding planning artifacts) |
| Work-item container | A directory holding individual work items / features (e.g., `changes/`, `specs/<id>-<name>/`, `_bmad-output/planning-artifacts/epics/`, or `.planning/phases/<NN-slug>/`) |
| Specification artifacts | Files describing what to build (e.g., a spec, proposal, requirements, PRD, architecture, roadmap, or plan document) |

### Secondary Signals (strengthen the score)

| Signal | What to check |
|--------|--------------|
| Spec CLI installed | A spec-driven CLI (e.g., OpenSpec, SpecKit's `specify`, BMAD's `bmad-method`, or GSD's `@opengsd/gsd-core`) responds to a version or status command |
| Spec CLI in deps | A spec-driven CLI is declared in a manifest (e.g., `bmad-method` or `@opengsd/gsd-core` in `package.json`, a spec CLI in `pyproject.toml`) or installed globally |
| Workflow skills | Repo-local skills for the spec workflow exist (e.g., under `.opencode/skills/`) |
| Workflow commands | Repo-local command definitions for the spec workflow exist (e.g., under `.opencode/command/` or as agent slash commands) |
| GitHub prompts | Spec-workflow prompt files exist under `.github/prompts/` |
| CONTRIBUTING.md reference | CONTRIBUTING.md describes the spec-driven workflow or its commands |
| AGENTS.md reference | AGENTS.md mentions the spec-driven workflow or points to the spec directory |

### Maturity Signals (differentiate score 2 vs 3 vs 4)

These signals are structural, directly observable in the repository's files, and apply identically to every spec system. Use whichever lifecycle convention the detected system follows -- do not require a specific tool's archive layout, and do not rely on information that cannot be observed in the files (such as remote pull-request state).

| Signal | What it indicates |
|--------|------------------|
| Non-empty work-item container | Work items / features have been created (score 2+) |
| Work items with complete artifacts | A work item has its full set of planning artifacts (e.g., requirements/spec plus an implementation plan and task breakdown, or the equivalent for the detected tool) with real content (score 3+) |
| Multiple work items | More than one feature/change has been planned through the system (score 3+) |
| Evidence of completed cycles | Finished work is visible on disk -- through an archive directory, an on-disk status/completion field, a fully checked task list, or another file-observable lifecycle marker the tool uses (score 4) |
| Recent activity | Recent timestamps on spec artifacts (file modification times or dated entries) indicate active use, not an abandoned setup (score 4) |
| Workflow integration in docs | Referenced in contributor or workflow documentation (score 4) |
| Valid CLI output | If a CLI is available, its status/check command exits 0 (score 4) |

---

## AI IDE Configuration Detection

Detect the AI IDE configuration. At least one of Cursor, VS Code/Copilot, Windsurf, Claude Code, or OpenCode must be configured. If none of these are detected, score Category 5 as 0 (do not mark as N/A).

### Cursor Signals

**Primary signals (any confirms Cursor):**

| Signal | What to check |
|--------|--------------|
| `.cursor/` directory | Exists at repo root |
| `.cursorrules` | Cursor rules file at repo root |
| `.cursor/rules/` | Directory containing Cursor rule files (`.mdc` or `.md`) |

**Secondary signals (strengthen the score):**

| Signal | What to check |
|--------|--------------|
| `.cursor/mcp.json` | MCP server configuration for Cursor |
| `.cursor/rules/*.mdc` | Individual rule files with frontmatter (`description`, `globs`, `alwaysApply`) |
| Cursor references in docs | CONTRIBUTING.md or AGENTS.md mentions Cursor setup |
| `.cursorignore` | Cursor ignore file |

**Config quality signals:**

| Signal | What it indicates |
|--------|------------------|
| `.cursorrules` or `.cursor/rules/` exist with repo-specific content | Beyond defaults (score 2+) |
| Rules reference repo architecture, conventions, and workflows | Tuned to the repo (score 3+) |
| MCP servers configured, multiple rule files for different contexts, rules use `globs` for scoping | Comprehensive setup (score 4) |

### VS Code / Copilot Signals

**Primary signals (any confirms VS Code/Copilot):**

| Signal | What to check |
|--------|--------------|
| `.github/copilot-instructions.md` | Copilot custom instructions file |
| `.github/copilot-*.md` | Any copilot instruction files |
| `.copilotignore` | Copilot ignore file |

**Secondary signals:**

| Signal | What to check |
|--------|--------------|
| Copilot extensions config | Extension definitions in `.github/` |
| Copilot references in docs | CONTRIBUTING.md or AGENTS.md mentions Copilot setup |
| VS Code settings for Copilot | `.vscode/settings.json` with Copilot-related keys |

**Config quality signals:**

| Signal | What it indicates |
|--------|------------------|
| Custom instructions exist with repo-specific content | Beyond defaults (score 2+) |
| Instructions reference repo architecture and conventions | Tuned to the repo (score 3+) |
| Multiple instruction files for different contexts | Comprehensive setup (score 4) |

### Windsurf Signals

**Primary signals (any confirms Windsurf):**

| Signal | What to check |
|--------|--------------|
| `.windsurf/` directory | Exists at repo root |
| `.windsurfrules` | Windsurf rules file at repo root |
| `.windsurf/rules/` | Directory containing Windsurf rule files |

**Secondary signals (strengthen the score):**

| Signal | What to check |
|--------|--------------|
| `.windsurf/mcp.json` | MCP server configuration for Windsurf |
| `.windsurf/rules/*.md` | Individual rule files |
| Windsurf references in docs | CONTRIBUTING.md or AGENTS.md mentions Windsurf setup |
| `.windsurfignore` | Windsurf ignore file |

**Config quality signals:**

| Signal | What it indicates |
|--------|------------------|
| `.windsurfrules` or `.windsurf/rules/` exist with repo-specific content | Beyond defaults (score 2+) |
| Rules reference repo architecture, conventions, and workflows | Tuned to the repo (score 3+) |
| MCP servers configured, multiple rule files for different contexts | Comprehensive setup (score 4) |

### Claude Code Signals

**Primary signals (any confirms Claude Code):**

| Signal | What to check |
|--------|--------------|
| `.claude/` directory | Exists at repo root |
| `CLAUDE.md` | Claude Code instructions file at repo root |
| `.claude/settings.json` | Claude Code settings file |

**Secondary signals (strengthen the score):**

| Signal | What to check |
|--------|--------------|
| `.claude/commands/` | Custom slash command definitions |
| `.claude/mcp.json` | MCP server configuration for Claude Code |
| Claude Code references in docs | CONTRIBUTING.md or AGENTS.md mentions Claude Code setup |
| `.claudeignore` | Claude Code ignore file |

**Config quality signals:**

| Signal | What it indicates |
|--------|------------------|
| `CLAUDE.md` exists with repo-specific content | Beyond defaults (score 2+) |
| Instructions reference repo architecture, conventions, and workflows | Tuned to the repo (score 3+) |
| MCP servers configured, custom commands defined, multiple context files | Comprehensive setup (score 4) |

### OpenCode Signals

**Primary signals (any confirms OpenCode):**

| Signal | What to check |
|--------|--------------|
| `opencode.jsonc` | Exists at repo root |
| `.opencode/` directory | Exists at repo root |

**Secondary signals (strengthen the score):**

| Signal | What to check |
|--------|--------------|
| `.opencode/package.json` | Plugin dependencies defined |
| `.opencode/plugin/` | Repo-local plugin code |
| `.opencode/command/` | Command definitions (`.md` files) |
| `.opencode/commands/` | Alternative command directory |
| `.opencode/skills/` | Repo-local skill definitions |
| `.opencode/ocx.jsonc` | ocx registry configuration |
| `.opencode/worktree.jsonc` | Worktree plugin sync config |

**Config quality signals (differentiate score 2 vs 3 vs 4):**

| Signal | What it indicates |
|--------|------------------|
| Plugins configured in `opencode.jsonc` | Beyond defaults (score 2+) |
| Core plugins present (DCP, plannotator, subtask2) | Standard workflow plugins (score 3+) |
| MCP server entries | Stack-matched integrations (score 3+) |
| Permission policies defined | Security-conscious config (score 4) |
| Provider restrictions defined | Intentional provider management (score 4) |
| `.opencode/package.json` dependencies resolve | Plugins are installable and maintained (score 4) |

---

## Deterministic Checks Detection

Detect the presence and configuration of each deterministic check type.

### Linter Detection

| Signal | Languages |
|--------|-----------|
| `.eslintrc`, `.eslintrc.*`, `eslint.config.*` | JavaScript/TypeScript |
| `ruff.toml`, `pyproject.toml` with `[tool.ruff]` | Python |
| `.flake8`, `setup.cfg` with `[flake8]` | Python |
| `checkstyle.xml`, `pmd.xml` | Java |
| `.prettierrc`, `.prettierrc.*`, `prettier.config.*` | JavaScript/TypeScript (formatting) |
| `.stylelintrc`, `.stylelintrc.*` | CSS |
| `lint` script in `package.json` | JavaScript/TypeScript |
| `lint` target in `Makefile` | Any |
| CI pipeline step named "lint" or running a lint command | Any |

### Type Checker Detection

| Signal | Languages |
|--------|-----------|
| `tsconfig.json`, `tsconfig.*.json` | TypeScript |
| `mypy.ini`, `pyproject.toml` with `[tool.mypy]`, `.mypy.ini` | Python |
| `pyrightconfig.json`, `pyproject.toml` with `[tool.pyright]` | Python |
| `pyproject.toml` with `[tool.basedpyright]` | Python |
| `pyproject.toml` with `[tool.pytype]` | Python |
| Java compiler (`javac`) with strict flags | Java |
| `typecheck` or `type-check` script in `package.json` | JavaScript/TypeScript |
| CI pipeline step running type check commands | Any |

### Test Runner Detection

| Signal | Languages |
|--------|-----------|
| `vitest.config.*`, `vite.config.*` with test config | JavaScript/TypeScript |
| `jest.config.*`, `package.json` with `jest` key | JavaScript/TypeScript |
| `pytest.ini`, `pyproject.toml` with `[tool.pytest]`, `conftest.py` | Python |
| `pom.xml` with surefire/failsafe plugin | Java |
| `build.gradle` with test config | Java |
| `test/`, `tests/`, `__tests__/`, `spec/` directories | Any |
| `test` script in `package.json` | JavaScript/TypeScript |
| `test` target in `Makefile` | Any |
| CI pipeline step named "test" or running test commands | Any |

### SAST / Security Scanning Detection

| Signal | Languages |
|--------|-----------|
| `.semgrep.yml`, `.semgrep/` | Any |
| `semgrep` in dependencies or CI steps | Any |
| `bandit.yaml`, `.bandit`, `pyproject.toml` with `[tool.bandit]` | Python |
| SpotBugs, FindBugs config | Java |
| `security` or `sast` CI pipeline step | Any |
| `security` script in `package.json` or `Makefile` | Any |

### Dependency / Vulnerability Audit Detection

| Signal | Languages |
|--------|-----------|
| `npm audit` or `yarn audit` in scripts or CI | JavaScript/TypeScript |
| `pip-audit` in dependencies or CI | Python |
| `safety` in dependencies or CI | Python |
| OWASP dependency-check config | Java |
| `audit` script in `package.json` | JavaScript/TypeScript |
| `audit` target in `Makefile` | Any |
| Dependabot config (`.github/dependabot.yml`) | Any |
| Renovate config (`renovate.json`, `.renovaterc`) | Any |
| CI pipeline step running audit commands | Any |

### Build Verification Detection

| Signal | Languages |
|--------|-----------|
| `build` script in `package.json` | JavaScript/TypeScript |
| `build` target in `Makefile` | Any |
| `Dockerfile`, `docker-compose.yml` | Any |
| `pom.xml` with package/install goals | Java |
| `build.gradle` with build tasks | Java |
| `pyproject.toml` with build system config | Python |
| CI pipeline step named "build" or running build commands | Any |

### Local Validation Path Detection

| Signal | What it indicates |
|--------|------------------|
| `make check`, `make validate`, `make ci` target | Unified validation command |
| `validate`, `check`, or `ci` script in `package.json` | Unified validation command |
| `scripts/validate.sh`, `scripts/ci.sh`, `scripts/check.sh` | Validation script |
| Pre-commit hooks (`.pre-commit-config.yaml`, `.husky/`) | Git hook-based validation |
| Pre-push hooks | Git hook-based validation |
| `docs/validation/local-validation-workflow.md` | Documented validation path |
| CI pipeline that mirrors local commands | CI parity |

---

## AI Skills Detection

### Skill Directory Signals

| Signal | What to check |
|--------|--------------|
| `skills/` directory at repo root | Contains skill subdirectories with `SKILL.md` files |
| `.opencode/skills/` directory | OpenCode-specific skills |
| `.github/skills/` directory | GitHub-specific skills |
| Skill subdirectories | Each subdirectory with a `SKILL.md` is one installed skill |

### Skills CLI

| Signal | What to check |
|--------|--------------|
| `npx skills list` | Returns installed skill inventory |
| `npx skills --version` | CLI is available |
| `package.json` with `skills` dependency | Skills CLI is a project dependency |

### Specific Skills to Look For

**Core workflow skills:**
- `create-pull-request-with-reviewers`
- `gh-pr-comment-resolution`
- `reflect-on-changes`

**Security skills:**
- `software-security` (from CodeGuard)
- Any skill with "security" in its name or description

**Stack-specific skills (examples):**
- React/frontend review skills
- LangGraph/LangChain skills
- Testing-focused skills

---

## Documentation Primitive Detection

### AGENTS.md

| Signal | What to check |
|--------|--------------|
| `AGENTS.md` at repo root | File exists |
| Line count | Over 200 lines suggests inline content dump (score reducer). Length alone is not a penalty -- a longer file is fine if the content is routing pointers and a repo map, not inlined documentation. |
| Content pattern | Contains links/pointers to `docs/` (routing file) vs. inline content (dump) |
| Repo map | Includes a directory structure tree showing the repo layout. |
| Freshness | References match actual file paths in the repo |
| Spec-driven development reference | Mentions the spec-driven development system or its change-planning workflow |

### CONTRIBUTING.md

| Signal | What to check |
|--------|--------------|
| `CONTRIBUTING.md` at repo root | File exists |
| References validation workflow | Mentions test, lint, or validation commands |
| References Spec-driven development | Mentions the spec-driven development system or a structured spec-driven process |
| References docs tree | Points to `docs/` for detailed guidance |
| Repo-specific content | Contains commands and workflows specific to this repo, not generic boilerplate |

### docs/ Directory Structure

| Signal | What it indicates |
|--------|------------------|
| `docs/` exists | Basic docs directory present |
| `docs/architecture/` | Architecture documentation (overview, services, data model) |
| `docs/dev-environment/` | Developer setup docs (first-time setup, running the app, env vars) |
| `docs/validation/` | Validation docs (local workflow, CI pipeline, testing strategy) |
| `docs/conventions/` | Coding standards and conventions |
| `docs/deployment/` | Deployment documentation |
| `docs/security/` | Security documentation |
| `docs/workflow-overview.md` | Top-level workflow explainer |
| `docs/tech-debt.md` | Known tech debt tracker |
| Cross-links between docs | Docs reference each other (score 4 signal) |
| Real content vs. scaffolds | Files contain repo-specific material, not placeholder text |
