package com.okta.pom.parser;

public enum Scope {
    compile,
    runtime,
    provided,
    system,
    import_,
    test;

    Scope toEnum(String name) {
        final Scope scope;

        switch (name) {
            case "import_": {
                scope = import_;

                break;
            }
            default: {
                scope = Scope.valueOf(name);

                break;
            }
        }

        return scope;
    }

}
