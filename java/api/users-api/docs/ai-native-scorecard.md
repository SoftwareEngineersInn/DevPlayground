# AI-Native Scorecard

## Repository

- **Name:** users-api (module `java/api/users-api` within the DevPlayground monorepo)
- **GitHub org:** SoftwareEngineersInn
- **Date assessed:** 2026-07-09
- **Detected stack:** Java 8 (JDK 1.8), Spring Boot 2.7.18, Maven, MongoDB (Spring Data), Lombok, springdoc-openapi (Swagger), Docker
- **Spec-Driven Development system:** None detected
- **AI IDE:** Claude Code (minimal — `.claude/settings.local.json` permission allowlist only)

## Summary

- **Overall score:** 0.56 / 4.0
- **Tier:** Unaware
- **Agentic legibility sub-score:** 1.83 / 4.0
- **Agentic legibility tier:** Nascent
- **Sub-metrics below 3:** 31 of 38

## Tier Definitions

| Composite Score | Tier | Description |
| --- | --- | --- |
| 0.0 - 0.9 | **Unaware** | No AI-native infrastructure exists. Agents would be flying blind. |
| 1.0 - 1.9 | **Nascent** | Fragments exist. AI use is opportunistic, not systematic. |
| 2.0 - 2.9 | **Structured** | Core primitives are in place. Agents can operate with some friction. |
| 3.0 - 3.5 | **Established** | AI workflow is reliable and actively used. Agents can operate effectively. |
| 3.6 - 4.0 | **Exemplary** | Model AI-native repo. Full infrastructure, actively maintained, intentionally curated. |

## Category Scores

| Category | Weight | Score (0-4) | Tier |
| --- | --- | --- | --- |
| Spec-Driven Development | 20% | 0.00 | Unaware |
| Deterministic Checks | 25% | 0.86 | Unaware |
| AI Tooling & Skills | 15% | 0.00 | Unaware |
| Documentation Tree | 15% | 0.25 | Unaware |
| AI IDE Configuration | 10% | 0.33 | Unaware |
| Agentic Legibility | 15% | 1.83 | Nascent |
| **Overall** | **100%** | **0.56** | **Unaware** |

## Detailed Scores

### Spec-Driven Development

- **Detected system:** None

| Sub-metric | Score (0-4) | Evidence |
| --- | --- | --- |
| System and artifacts | 0 | No `openspec/`, `.specify/`, `_bmad/`, `.planning/`, or planning-artifact `specs/` directory anywhere in the module. No spec-driven workflow present. |
| Workflow commands | 0 | No spec workflow commands, prompts, or skills (e.g., create-spec / apply-spec) found. |
| Documentation | 0 | No documentation describing a spec-driven process; no `AGENTS.md` or `CONTRIBUTING.md` references it. |

### Deterministic Checks

| Sub-metric | Score (0-4) | Evidence |
| --- | --- | --- |
| Linting | 0 | No linter configured in `pom.xml` (no Checkstyle, Spotless, PMD, or SpotBugs plugin). No lint step exists. |
| Type checking | 2 | Java is statically typed and `mvn package`/`mvn verify` fails on type errors, giving local type enforcement via the compiler. No dedicated type gate and no CI enforcement (strictness not proven). |
| Testing | 2 | JUnit 5 tests present (`src/test/java/.../UserControllerTest.java`, `UsersApiApplicationTests.java`); run via `mvn verify`. Local-only, not enforced in CI; coverage not measured. |
| SAST / Security scanning | 0 | No SAST tooling (no SpotBugs/find-sec-bugs, Semgrep, CodeQL) configured. |
| Dependency / Vulnerability audit | 0 | No dependency audit (no OWASP dependency-check plugin, no Dependabot/renovate config). |
| Build verification | 2 | `mvn package` builds the artifact via `spring-boot-maven-plugin`; `docker/Dockerfile` packages the jar. Local-only, not enforced in CI. |
| Local validation path | 0 | No single validate entry point (no Makefile, `scripts/validate`, or aggregated verify script). Commands must be assembled from the README. |

### AI Tooling & Skills

| Sub-metric | Score (0-4) | Evidence |
| --- | --- | --- |
| Workflow skills | 0 | No skill in a `skills/` or `.opencode/skills/` directory (the categories counted here). A skill exists under the non-standard `.agents/skills/ai-native-assessment/` path (plus `skills-lock.json` at module root), but it is the assessment tool itself, not a repo workflow skill, and its location is outside the counted directories. |
| Security review skills | 0 | No security-review skill present. |
| Skill relevance | 0 | No qualifying skills tailored to this Spring Boot / MongoDB codebase. |

### Documentation Tree

| Sub-metric | Score (0-4) | Evidence |
| --- | --- | --- |
| AGENTS.md | 0 | No `AGENTS.md` at the module root. |
| CONTRIBUTING.md | 0 | No `CONTRIBUTING.md`. |
| docs/ structure | 0 | No `docs/` directory prior to this assessment (no architecture/validation/guides/api subtree). |
| Content quality | 1 | A single `README.md` with tech stack, run commands, a practice checklist, and a Swagger link; plus the Spring-generated `HELP.md`. Useful but shallow — no structured, agent-oriented documentation tree. |

### AI IDE Configuration

- **Detected IDE:** Claude Code

| Sub-metric | Score (0-4) | Evidence |
| --- | --- | --- |
| Config exists | 1 | `.claude/settings.local.json` exists but contains only an auto-generated Bash/Read permission allowlist (largely artifacts of this assessment run). No `CLAUDE.md`. No Cursor/Windsurf/Copilot/OpenCode config. |
| Commands / Skills | 0 | No IDE-scoped commands, prompts, or chatmodes. |
| MCP servers | 0 | No MCP server configuration. |

### Agentic Legibility

- **Sub-assessment score:** 1.83
- **Sub-assessment tier:** Nascent

| Dimension | Metric | Score (0-4) | Notes | Evidence |
| --- | --- | --- | --- | --- |
| Repository Orientation | Agent repo map | 0 | No architecture map or directory-purpose summary. | No `AGENTS.md`; README lists a tech stack but no system/component map. |
| Repository Orientation | Entry point clarity | 3 | Startup path is clearly documented for a single-service app. | README documents `mvn spring-boot:run`, Docker build/run, and the Swagger URL; `UsersApiApplication.java` is the obvious entrypoint. |
| Information Findability | Context proximity | 2 | Codebase is tiny and self-evident, but there is no colocated context. | No module READMEs or header/docstring comments; purpose must be inferred by reading each class. |
| Information Findability | Change-relevant discoverability | 1 | No guidance on downstream impact or coupling. | No notes on how changing `User`/`UserDto`/schema propagates; agent must infer from imports. |
| Codebase Navigability | Naming and path semantics | 3 | Conventional Spring Boot layout is highly predictable. | `controller/`, `dto/`, `model/`, `service/`, `respository/` packages map cleanly to behavior. Minor: `respository` is misspelled and `EmailService` is an empty stub. |
| Codebase Navigability | Locality of concern | 3 | Standard Maven layout with tests mirroring source. | `UserControllerTest` sits under the matching `controller` test package; `src/main` vs `src/test` split is clear. |
| Task Executability | Setup reproducibility | 2 | No single self-contained bootstrap. | `docker-compose.yml` builds only the API with `depends_on: []` and no MongoDB service; app targets external `host.docker.internal:27017`. No Maven wrapper (`mvnw`); relies on a system Maven and a manually provided Mongo. |
| Task Executability | Task runbooks | 1 | Run commands only; no procedures for common changes. | README covers running the app but has no runbook for adding an endpoint, changing the schema, or debugging. |
| Verification Legibility | Test discoverability | 3 | Source-to-test mapping is pattern-matchable. | Tests mirror source structure under `src/test`; `mvn test`/`mvn verify` runs them. |
| Verification Legibility | Verification path clarity | 1 | No documented definition of done. | README does not mention running tests; no lint/typecheck/CI gates to indicate what "sufficient" verification is. |
| Intent and Invariants | Business logic explainability | 1 | Domain rationale is not documented. | Only implicit rule is the `@Min(18)` age constraint with an inline message; no ADRs or rationale docs. |
| Intent and Invariants | Invariant visibility | 2 | Data-integrity constraints are surfaced via annotations. | `UserDto` uses `@NotBlank`, `@Email`, `@Min(18)`; no documented auth/compatibility/performance invariants (security is explicitly an unchecked TODO in README). |
| Safety Boundaries | Generated vs editable boundaries | 2 | Little committed generated code to confuse an agent. | Swagger/OpenAPI is generated at runtime (not committed); Lombok generates at compile. No generated-file banners, but low risk of accidental edits. |
| Safety Boundaries | Risk surface annotation | 1 | Sensitive areas are not annotated. | No warnings on data mutation endpoints; no auth layer. README notes security is not yet implemented, which is a weak signal. |
| Machine-Friendliness | Explicit conventions | 1 | Conventions are implicit Spring Boot norms. | No `CONTRIBUTING.md`, coding standards, or file-placement rules written down. |
| Machine-Friendliness | Structured metadata | 2 | Some machine-readable contracts exist. | `pom.xml` dependency manifest and springdoc/OpenAPI annotations (`@Tag`, `@Operation`) yield an interface contract; no ownership/architecture metadata. |
| Freshness and Trustworthiness | Documentation freshness | 2 | README mostly matches reality but has drifted. | Run commands still valid; however README lists "Error handling" as an unchecked TODO while `GlobalExceptionHandler` is already implemented. |
| Freshness and Trustworthiness | Drift detection | 0 | No mechanism to catch doc/config/behavior drift. | No CI, no docs linting, no example validation. |

#### Agentic Legibility Strengths

- Conventional, predictable Spring Boot package structure (`controller`/`dto`/`model`/`service`/`repository`) with tests mirroring source — an agent can navigate and locate tests without guesswork.
- Clear single-service entrypoint and run instructions in the README, plus OpenAPI/Swagger annotations that document the HTTP contract.

#### Agentic Legibility Gaps

- No agent repo map, no documented invariants/risk surfaces, and no verification "definition of done."
- Setup is not self-contained (external MongoDB required, no bootstrap script, no Maven wrapper), and there is no drift detection or CI.

#### Highest-Leverage Legibility Improvements

1. Add an `AGENTS.md` repo map that names the entrypoint, describes each package, and states the run + verify commands.
2. Make setup self-contained: add a MongoDB service to `docker-compose.yml` (with a dev default/seed) and commit the Maven wrapper (`mvnw`) so a fresh clone builds and runs with one command.
3. Document the verification path and invariants (how to run tests, what "done" means, the age/email/uniqueness rules) near the code.

#### Agentic Legibility Final Judgment

An autonomous agent could navigate this small codebase and run its tests with modest effort — naming and layout are conventional and the entrypoint is clear. However, it could not reliably get from a fresh clone to a running app without human help (external MongoDB, no bootstrap), could not tell what verification is sufficient (no documented validate path, no CI), and would have no explicit statement of invariants or risky areas to preserve. The biggest blockers are non-self-contained setup, absent invariant/risk documentation, and no drift detection.

## Key Strengths

- **Clean, idiomatic structure.** Standard Spring Boot package layout and Maven `src/main` vs `src/test` split make the module easy to navigate; tests mirror the controller under test (`UserControllerTest`).
- **Working test and build capability.** JUnit 5 tests exist and run via `mvn verify`; `mvn package` + `docker/Dockerfile` produce a runnable artifact.
- **HTTP contract is documented in code.** springdoc-openapi annotations (`@Tag`, `@Operation`) plus a Swagger UI link give a machine-readable API contract.
- **Basic validation and error handling.** `UserDto` bean-validation annotations and a `GlobalExceptionHandler` provide a consistent error surface.

## Key Gaps

- **No CI and no enforced gates.** The only CI in the monorepo lives under `mlops/.github/ci.yml`; `users-api` has no pipeline. Linting, SAST, dependency audit, coverage, and a single local-validation entry point are all absent — nothing mechanically prevents regressions.
- **No agent-facing documentation tree.** No `AGENTS.md`, `CONTRIBUTING.md`, or `docs/` structure; the only prose is a shallow README plus Spring's boilerplate `HELP.md`.
- **No spec-driven workflow and no counted AI skills/IDE tooling.** No spec system; the sole skill sits under the non-standard `.agents/skills/` path; the only IDE config is an incidental `.claude/settings.local.json` permission allowlist.
- **Setup is not reproducible unattended.** `docker-compose.yml` omits MongoDB (`depends_on: []`) and the app targets an external Mongo; there is no bootstrap script and no committed Maven wrapper.

## Recommended Actions

| Priority | Action | Category | Sub-metric | Current | Target | Impact |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | Add a linter to `pom.xml` (e.g., Spotless or Checkstyle) and wire it into `mvn verify`. | Deterministic Checks | Linting | 0 | 3 | 0.1875 |
| 2 | Add SAST (e.g., SpotBugs + find-sec-bugs or a CodeQL workflow) that fails on findings. | Deterministic Checks | SAST / Security scanning | 0 | 3 | 0.1875 |
| 3 | Add dependency-vulnerability auditing (OWASP dependency-check plugin or Dependabot). | Deterministic Checks | Dependency / Vulnerability audit | 0 | 3 | 0.1875 |
| 4 | Provide a single local validation entry point (Makefile or `scripts/validate` running build + tests + lint). | Deterministic Checks | Local validation path | 0 | 3 | 0.1875 |
| 5 | Introduce a spec-driven workflow (e.g., OpenSpec/SpecKit) with a real planning artifact for a change. | Spec-Driven Development | System and artifacts | 0 | 3 | 0.15 |
| 6 | Add spec workflow commands/skills (create-spec, apply-spec) for the chosen system. | Spec-Driven Development | Workflow commands | 0 | 3 | 0.15 |
| 7 | Document the spec-driven process in `AGENTS.md`/`CONTRIBUTING.md`. | Spec-Driven Development | Documentation | 0 | 3 | 0.15 |
| 8 | Add a workflow skill under `skills/` tailored to this repo (e.g., "add REST endpoint"). | AI Tooling & Skills | Workflow skills | 0 | 3 | 0.1125 |
| 9 | Add a security-review skill under `skills/`. | AI Tooling & Skills | Security review skills | 0 | 3 | 0.1125 |
| 10 | Ensure installed skills are relevant to this Spring Boot/MongoDB stack. | AI Tooling & Skills | Skill relevance | 0 | 3 | 0.1125 |
| 11 | Create `AGENTS.md` with a repo map, entrypoint, and run/verify commands. | Documentation Tree | AGENTS.md | 0 | 3 | 0.1125 |
| 12 | Add `CONTRIBUTING.md` covering setup, validation, and conventions. | Documentation Tree | CONTRIBUTING.md | 0 | 3 | 0.1125 |
| 13 | Create a `docs/` tree (architecture, running-the-app, api) with real content. | Documentation Tree | docs/ structure | 0 | 3 | 0.1125 |
| 14 | Add an agent repo map (top-level architecture + package purposes). | Agentic Legibility | Repository Orientation / Agent repo map | 0 | 3 | 0.1125 |
| 15 | Add a docs/config drift check in CI (markdown lint or generated-API-doc validation). | Agentic Legibility | Freshness / Drift detection | 0 | 3 | 0.1125 |
| 16 | Add IDE-scoped commands/skills (e.g., a `CLAUDE.md` and reusable commands). | AI IDE Configuration | Commands / Skills | 0 | 3 | 0.075 |
| 17 | Configure at least one MCP server useful to this repo. | AI IDE Configuration | MCP servers | 0 | 3 | 0.075 |
| 18 | Document downstream coupling (schema/DTO change propagation) near the code. | Agentic Legibility | Information Findability / Change-relevant discoverability | 1 | 3 | 0.075 |
| 19 | Add task runbooks (add endpoint, change schema, debug) to the docs. | Agentic Legibility | Task Executability / Task runbooks | 1 | 3 | 0.075 |
| 20 | Document the verification path / definition of done (how to run tests, what is sufficient). | Agentic Legibility | Verification Legibility / Verification path clarity | 1 | 3 | 0.075 |
| 21 | Document business-logic rationale (why age >= 18, uniqueness expectations) via comments/ADRs. | Agentic Legibility | Intent and Invariants / Business logic explainability | 1 | 3 | 0.075 |
| 22 | Annotate risk surfaces (mutation endpoints, missing auth) with warnings/review notes. | Agentic Legibility | Safety Boundaries / Risk surface annotation | 1 | 3 | 0.075 |
| 23 | Write down repo-specific conventions (patterns to copy, anti-patterns). | Agentic Legibility | Machine-Friendliness / Explicit conventions | 1 | 3 | 0.075 |
| 24 | Improve README/docs into an actionable, agent-oriented documentation set. | Documentation Tree | Content quality | 1 | 3 | 0.075 |
| 25 | Add a dedicated type-check gate and enforce compilation in CI. | Deterministic Checks | Type checking | 2 | 3 | 0.0625 |
| 26 | Add test enforcement in CI plus coverage reporting/gating. | Deterministic Checks | Testing | 2 | 3 | 0.0625 |
| 27 | Enforce the build in CI on PRs/mainline. | Deterministic Checks | Build verification | 2 | 3 | 0.0625 |
| 28 | Make `.claude/` intentional: add a `CLAUDE.md` describing the module for agents. | AI IDE Configuration | Config exists | 1 | 3 | 0.05 |
| 29 | Add colocated module context (package-info/header comments stating responsibility). | Agentic Legibility | Information Findability / Context proximity | 2 | 3 | 0.0375 |
| 30 | Make setup self-contained (add MongoDB to compose, commit `mvnw`, dev defaults). | Agentic Legibility | Task Executability / Setup reproducibility | 2 | 3 | 0.0375 |
| 31 | Document non-validation invariants (auth, compatibility) explicitly. | Agentic Legibility | Intent and Invariants / Invariant visibility | 2 | 3 | 0.0375 |
| 32 | Mark generated vs hand-edited boundaries (Lombok/OpenAPI) where relevant. | Agentic Legibility | Safety Boundaries / Generated vs editable boundaries | 2 | 3 | 0.0375 |
| 33 | Add structured metadata (CODEOWNERS, architecture index, committed OpenAPI spec). | Agentic Legibility | Machine-Friendliness / Structured metadata | 2 | 3 | 0.0375 |
| 34 | Update README to match reality (error handling is implemented) and keep it current. | Agentic Legibility | Freshness / Documentation freshness | 2 | 3 | 0.0375 |
