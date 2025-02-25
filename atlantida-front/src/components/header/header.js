import styles from "./header.module.css";

const Header = () => {
    return (
        <header className={styles.header}>
            <div className={styles.brand}>
                <img src="/assets/images/logo.svg" alt="logo" className={styles.logo}/>
                <div className={styles.title}>
                    <h1 className={styles.titleText}>ATLÂNTIDA</h1>
                    <h2 className={styles.titleText}>PESCADOS</h2>
                </div>
            </div>

            <div className={styles.inputOptions}>
                <div className={styles.signup}>
                    <p>Cadastre-se</p>
                </div>
                <div className={styles.login}>
                    <p>Fazer Login</p>
                </div>
            </div>
        </header>
    );
};

export default Header;