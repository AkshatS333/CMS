
INSERT INTO ROLES(id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO users (id, email, name, password, username) VALUES
(51, 'rahul.sharma@example.com', 'Rahul Sharma',
 '$2a$10$k2v3sg9Mr7K24yoh.PJeOuolLyxbnnvW21kWRMmhs3tdtyw.jrROy', 'rahul_s'),

(52, 'anita.verma@example.com', 'Anita Verma',
 '$2a$10$k2v3sg9Mr7K24yoh.PJeOuolLyxbnnvW21kWRMmhs3tdtyw.jrROy', 'anita_v'),

(53, 'rohit.kumar@example.com', 'Rohit Kumar',
 '$2a$10$k2v3sg9Mr7K24yoh.PJeOuolLyxbnnvW21kWRMmhs3tdtyw.jrROy', 'rohit_k'),

(54, 'neha.patel@example.com', 'Neha Patel',
 '$2a$10$k2v3sg9Mr7K24yoh.PJeOuolLyxbnnvW21kWRMmhs3tdtyw.jrROy', 'neha_p'),

(55, 'arjun.mehta@example.com', 'Arjun Mehta',
 '$2a$10$k2v3sg9Mr7K24yoh.PJeOuolLyxbnnvW21kWRMmhs3tdtyw.jrROy', 'arjun_m');



INSERT INTO USER_ROLES (role_id, user_id) VALUES
(1,51),
(1,55),
(2,52),
(2,53),
(2,54);

INSERT INTO categories (id, name, description) VALUES
(51, 'Backend Engineering', 'Backend standards, API design, and service development'),
(52, 'Platform & Infrastructure', 'CI/CD pipelines, cloud infrastructure, runtime platforms'),
(53, 'Data Engineering', 'Database design, migrations, and performance tuning'),
(54, 'Security & Compliance', 'Authentication, authorization, and compliance guidelines'),
(55, 'Architecture & Design', 'System design decisions, RFCs, and technical standards');


INSERT INTO posts (
    id,
    category_id,
    title,
    description,
    content
) VALUES
(
  51,
  51,
  'Backward-Compatible REST API Design Guidelines',
  'Internal standards for evolving REST APIs without breaking consumers.',
  'This document defines the organization-wide standards for REST API versioning, deprecation policies, backward compatibility guarantees, and contract testing expectations.'
),
(
  52,
  54,
  'JWT Authentication and Role Enforcement Standards',
  'Standardized approach for JWT-based authentication across services.',
  'This document outlines how JWT tokens must be issued, validated, rotated, and enforced across backend services, including role-based authorization strategies.'
),
(
  53,
  53,
  'PostgreSQL Indexing Strategy for High-Traffic Services',
  'Approved indexing patterns for PostgreSQL-backed services.',
  'Details best practices for PostgreSQL indexing, including B-tree vs GIN indexes, partial indexes, write amplification considerations, and index maintenance.'
),
(
  54,
  52,
  'CI/CD Pipeline Architecture for Spring Boot Services',
  'Reference CI/CD architecture used across backend teams.',
  'Explains the standardized CI/CD pipeline architecture, covering build isolation, artifact promotion, blue-green deployments, and rollback strategies.'
),
(
  55,
  55,
  'RFC: CMS Architecture and Authorization Model',
  'Design rationale for the internal CMS platform.',
  'This RFC documents the architectural decisions behind the CMS, including entity relationships, authorization boundaries, moderation rules, and extensibility considerations.'
);


INSERT INTO comment (
    id,
    post_id,
    body,
    email,
    name
) VALUES
(
  51,
  51,
  'Should we mandate contract testing for all externally consumed APIs, or only for cross-team integrations?',
  'anita.verma@example.com',
  'Anita Verma'
),
(
  52,
  51,
  'We should also clarify the deprecation notice period expected before removing older API versions.',
  'rohit.kumar@example.com',
  'Rohit Kumar'
),
(
  53,
  52,
  'Do we enforce asymmetric JWT signing keys for internal services, or is this limited to edge services?',
  'neha.patel@example.com',
  'Neha Patel'
),
(
  54,
  53,
  'It may be useful to add guidelines on monitoring index bloat and scheduling reindex operations.',
  'anita.verma@example.com',
  'Anita Verma'
),
(
  55,
  53,
  'How should teams handle long-running migrations without impacting write-heavy workloads?',
  'arjun.mehta@example.com',
  'Arjun Mehta'
),
(
  56,
  54,
  'Suggest adding a section on rollback timelines and communication during failed production deployments.',
  'rohit.kumar@example.com',
  'Rohit Kumar'
),
(
  57,
  55,
  'Should CMS content visibility be role-based only, or should we plan for team-level access control in the future?',
  'neha.patel@example.com',
  'Neha Patel'
);


