ALTER TABLE users ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE tasks ALTER COLUMN id SET DEFAULT gen_random_uuid();

